package com.szw.missyou.validators;


import com.szw.missyou.dto.Person;
import org.thymeleaf.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @Auther: szw
 * @Date: 2023/8/8 - 08 - 08 - 16:58
 * @Description: com.szw.missyou.validators
 * @version: 1.0
 */

public class TokenVlidate implements ConstraintValidator<TokenEqual, String> {
    private Integer min;
    private Integer max;


    @Override
    public void initialize(TokenEqual constraintAnnotation) {
        this.min = constraintAnnotation.min();
        this.max = constraintAnnotation.max();
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if (StringUtils.isEmpty(s)) {
            return true;

        }
        return s.length() >= this.min && s.length() <= this.max;
    }
}