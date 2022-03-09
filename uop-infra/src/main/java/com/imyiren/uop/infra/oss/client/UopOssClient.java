package com.imyiren.uop.infra.oss.client;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.ObjectMetadata;
import com.aliyun.oss.model.PutObjectRequest;
import com.aliyun.oss.model.PutObjectResult;
import com.imyiren.uop.domain.repository.entity.StorageInfoDO;
import com.imyiren.uop.domain.repository.entity.StorageUploadDO;
import com.imyiren.uop.domain.repository.entity.StorageUploadResultDO;
import com.imyiren.uop.infra.oss.config.OssProperties;
import com.imyiren.utils.common.UuidUtils;
import lombok.Data;

import java.io.ByteArrayInputStream;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author yiren
 */
@Data
public class UopOssClient {
    private OSS ossClient;
    private OssProperties ossProperties;

    public UopOssClient(OssProperties ossProperties) {

        // Endpoint以华东1（杭州）为例，其它Region请按实际情况填写。关于其他Region对应的Endpoint信息，请参见访问域名和数据中心。"https://oss-cn-hangzhou.aliyuncs.com";
        String endpoint = ossProperties.getEndpoint();
        // 阿里云账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM用户进行API访问或日常运维，请登录RAM控制台创建RAM用户。
        String accessKeyId = ossProperties.getAccessKeyId();
        String accessKeySecret = ossProperties.getAccessKeySecret();
        this.ossProperties = ossProperties;
        // 创建OSSClient实例。
        ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
    }

    public StorageUploadResultDO upload(StorageUploadDO storageUpload) {
        String code = UuidUtils.generate();

        // 创建PutObjectRequest对象。
        String filePathAndName = getFilePathAndName(code, storageUpload.getFilename());
        PutObjectRequest putObjectRequest = new PutObjectRequest(
                ossProperties.getBucketName(),
                filePathAndName,
                new ByteArrayInputStream(storageUpload.getData()));

        // 禁止覆盖同名文件
        ObjectMetadata metadata = new ObjectMetadata();
        metadata.setHeader("x-oss-forbid-overwrite", "true");
        putObjectRequest.setMetadata(metadata);

        // 上传
        PutObjectResult putObjectResult = ossClient.putObject(putObjectRequest);
        StorageUploadResultDO storageUploadResult = new StorageUploadResultDO();
        storageUploadResult.setSuccess(true);
        storageUploadResult.setUrl("https://" + ossProperties.getDomain() + "/" + filePathAndName);
        storageUploadResult.setFilename(storageUpload.getFilename());
        storageUploadResult.setCode(code);

        return storageUploadResult;
    }

    public String getFilePathAndName(String code, String name) {
        LocalDateTime now = LocalDateTime.now();
        String time = String.format("%02d%02d%02d%02d-", now.getDayOfMonth(), now.getHour(), now.getMinute(), now.getSecond());
        return String.format("%s/%d/%02d/%s/%s",
                ossProperties.getPrefix(),
                now.getYear(),
                now.getMonth().getValue(),
                time + code, name);
    }

    public Boolean delete(StorageInfoDO storageInfoDO) {
        ossClient.deleteObject(
                ossProperties.getBucketName(),
                storageInfoDO.getUrl().replace("https://" + ossProperties.getDomain() + "/", "")
        );
        return Boolean.TRUE;
    }

}
