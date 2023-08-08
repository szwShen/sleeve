package com.szw.missyou.dto;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @Auther: szw
 * @Date: 2023/8/8 - 08 - 08 - 16:52
 * @Description: com.szw.missyou.dto
 * @version: 1.0
 */
@Getter
@Setter
public class TokenGetDto {
    @NotBlank(message = "不许为空")
    private String account;
    @TokenPassword(min = 6, max = 30, message = "{token.password}")
    private String password;
    private LoginType type;

}
