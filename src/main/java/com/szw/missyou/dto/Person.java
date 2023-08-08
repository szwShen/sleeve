package com.szw.missyou.dto;

import com.szw.missyou.validators.PasswordEqual;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

/**
 * @Auther: szw
 * @Date: 2023/8/3 - 08 - 03 - 22:12
 * @Description: com.szw.missyou.dto
 * @version: 1.0
 */
@Data
@PasswordEqual(min = 1,max = 6,message = "兩次密碼不一致")
public class Person {
    @Length(min = 2,max = 11,message = "少了")
    private String name;
    private Integer age;

    private String password1;
    private String Password2;
}
