package com.imyiren.uop.request;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class UserSavePasswordRequest implements Serializable {
    /**
     * ID
     */
    @NotNull(message = "用户ID不能为空")
    private Long id;

    private String password;
    private String newPassword;

}
