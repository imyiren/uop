package com.imyiren.uop.application.utils;

import com.github.pagehelper.PageInfo;
import com.imyiren.application.api.dto.PageDTO;
import org.springframework.util.CollectionUtils;

import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

public class PageUtils {


    public static  <S, T> PageDTO<T> toPageDTO(PageInfo<S> pageInfo, Function<S, T> function) {
        if (Objects.isNull(pageInfo) || CollectionUtils.isEmpty(pageInfo.getList())) {
            return null;
        }
        PageDTO<T> pageDTO = new PageDTO<>();
        pageDTO.setPageNum(pageInfo.getPageNum());
        pageDTO.setPageSize(pageInfo.getPageSize());
        pageDTO.setTotalSize(pageInfo.getTotal());
        pageDTO.setTotalPage((long) pageInfo.getPages());
        pageDTO.setHasNextPage(pageInfo.isHasNextPage());
        pageDTO.setHasPrevPage(pageInfo.isHasPreviousPage());
        pageDTO.setDataList(pageInfo.getList().stream().map(function).collect(Collectors.toList()));
        return pageDTO;


    }
}
