package com.imyiren.uop.domain.utils;

import com.github.pagehelper.PageInfo;
import org.springframework.util.CollectionUtils;

import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author yiren
 */
public class PageInfoUtils {


    public static <S, T> PageInfo<T> transfer(PageInfo<S> pageInfo, Function<S, T> function) {
        if (Objects.isNull(pageInfo) || CollectionUtils.isEmpty(pageInfo.getList())) {
            return new PageInfo<>();
        }
        PageInfo<T> result = new PageInfo<>();
        result.setPageNum(pageInfo.getPageNum());
        result.setPageSize(pageInfo.getPageSize());
        result.setSize(pageInfo.getSize());
        result.setStartRow(pageInfo.getStartRow());
        result.setEndRow(pageInfo.getEndRow());
        result.setPages(pageInfo.getPages());
        result.setPrePage(pageInfo.getPrePage());
        result.setNextPage(pageInfo.getNextPage());
        result.setIsFirstPage(pageInfo.isIsFirstPage());
        result.setIsLastPage(pageInfo.isIsLastPage());
        result.setHasPreviousPage(pageInfo.isHasPreviousPage());
        result.setHasNextPage(pageInfo.isHasNextPage());
        result.setNavigatePages(pageInfo.getNavigatePages());
        result.setNavigatepageNums(pageInfo.getNavigatepageNums());
        result.setNavigateFirstPage(pageInfo.getNavigateFirstPage());
        result.setNavigateLastPage(pageInfo.getNavigateLastPage());
        result.setTotal(pageInfo.getTotal());
        result.setList(pageInfo.getList().stream().map(function).collect(Collectors.toList()));
        return result;
    }
}
