package com.imyiren.uop.domain.repository.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class UserExtraInfoDO implements Serializable {

    private List<String> roleList;


}
