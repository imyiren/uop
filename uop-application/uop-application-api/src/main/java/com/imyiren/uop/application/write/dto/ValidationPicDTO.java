package com.imyiren.uop.application.write.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author yiren
 */
@Data
public class ValidationPicDTO implements Serializable {

    private Long id;

    private String picKey;

    private String imgEncodeByBase64;

}
