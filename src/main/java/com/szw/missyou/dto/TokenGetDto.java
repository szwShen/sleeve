package com.szw.missyou.dto;

import com.szw.missyou.enumeration.LoginType;
import com.szw.missyou.validators.TokenEqual;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @Auther: szw
 * @Date: 2023/8/8 - 08 - 08 - 16:52
 * @Description: com.szw.missyou.dto
 * @version: 1.0
 */
@Data
public class TokenGetDto {
    @NotBlank(message = "account不许为空")
    private String account;
    @TokenEqual(min = 6, max = 30, message = "{token.password}")
    private String password;
    private LoginType loginType;

}
