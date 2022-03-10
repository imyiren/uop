package com.imyiren.uop.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author yiren
 */
@Data
public class ValidationPicVO implements Serializable {

    private String picKey;

    private String imgEncodeByBase64;

}
