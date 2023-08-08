package com.szw.missyou.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * @Auther: szw
 * @Date: 2023/8/8 - 08 - 08 - 16:59
 * @Description: com.szw.missyou.validators
 * @version: 1.0
 */

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
@Constraint(validatedBy = TokenVlidate.class)
public @interface TokenEqual {
    int min() default 4;

    int max() default 6;

    String message() default "password is not equal";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
