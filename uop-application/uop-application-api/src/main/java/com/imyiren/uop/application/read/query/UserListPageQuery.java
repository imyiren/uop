package com.imyiren.uop.application.read.query;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author yiren
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserListPageQuery implements Serializable {

    /**
     * 页号
     */
    @NotNull
    @Min(value = 1,message = "页号不正确！")
    private Integer pageNum;

    /**
     * 页大小
     */
    @NotNull
    @Min(value = 10, message = "分页数据大小应在10-100之间！")
    @Max(value = 100, message = "分页数据大小应在10-100之间！")
    private Integer pageSize;

    /**
     * 用户名
     */
    private String username;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 真实姓名
     */
    private String realName;

}
