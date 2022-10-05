package com.imyiren.uop.utils;

import com.imyiren.application.api.dto.PageDTO;
import com.imyiren.result.BizPageResults;
import com.imyiren.result.BizStateCodes;
import com.imyiren.result.base.BizPageResult;
import org.springframework.util.CollectionUtils;

import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

public final class PageUtils {

    public static <T, S> BizPageResult<T> toBizPageResult(PageDTO<S> pageDTO, Function<S, T> function) {
        if (Objects.isNull(pageDTO) || CollectionUtils.isEmpty(pageDTO.getDataList())) {
            return BizPageResults.success(null);
        }
        BizPageResult<T> bizPageResult = new BizPageResult<>();
        bizPageResult.setPageNum(pageDTO.getPageNum());
        bizPageResult.setPageSize(pageDTO.getPageSize());
        bizPageResult.setActualSize(pageDTO.getDataList().size());
        bizPageResult.setTotalSize(pageDTO.getTotalSize());
        bizPageResult.setTotalPage(pageDTO.getTotalPage());
        bizPageResult.setHasNextPage(pageDTO.getHasNextPage());
        bizPageResult.setHasPrePage(pageDTO.getHasPrevPage());
        bizPageResult.setData(pageDTO.getDataList().stream().map(function).collect(Collectors.toList()));
        bizPageResult.setCode(BizStateCodes.SUCCESS.getCode());
        return bizPageResult;
    }
}
