package com.imyiren.uop.convertor;

import com.imyiren.application.api.dto.PageDTO;
import com.imyiren.result.BizPageResults;
import com.imyiren.result.base.BizPageResult;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author yiren
 */
public abstract class PageConvertor {

    public static <R, T> BizPageResult<T> toBizPageResult(PageDTO<R> source, Function<R, T> function) {
        if (Objects.isNull(source) || CollectionUtils.isEmpty(source.getDataList())) {
            return BizPageResults.success(null, 1, null, 0L);
        }
        List<T> result = source.getDataList().stream().map(function).collect(Collectors.toList());
        return BizPageResults.success(result, source.getPageNum(), source.getPageSize(), source.getTotalSize());
    }

}
