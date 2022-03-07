package com.imyiren.uop.domain.repository.query;

import lombok.Data;

import java.io.Serializable;

/**
 * @author yiren
 */
@Data
public class UserGetQuery implements Serializable {

    private Long id;

    private String code;

    private String username;

    private String phone;

    private String email;

    private Integer state;

}
