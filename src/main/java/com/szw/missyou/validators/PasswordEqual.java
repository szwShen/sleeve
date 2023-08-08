package com.szw.missyou.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * @Auther: szw
 * @Date: 2023/8/3 - 08 - 03 - 22:16
 * @Description: com.szw.missyou.validators
 * @version: 1.0
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Constraint(validatedBy = PasswordValidate.class)
public @interface PasswordEqual {
    int min() default 4;

    int max() default 6;

    String message() default "password is not equal";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
