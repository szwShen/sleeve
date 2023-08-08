package com.szw.missyou.validators;

import com.szw.missyou.dto.Person;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @Auther: szw
 * @Date: 2023/8/8 - 08 - 08 - 16:58
 * @Description: com.szw.missyou.validators
 * @version: 1.0
 */

public class TokenVlidate implements ConstraintValidator<PasswordEqual, Person> {
    private int min;
    private int max;

    @Override
    public void initialize(PasswordEqual constraintAnnotation) {
        this.min = constraintAnnotation.min();
        this.max = constraintAnnotation.max();
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Person person, ConstraintValidatorContext constraintValidatorContext) {
        System.out.println(person.getPassword2().equals(person.getPassword1()));
        return person.getPassword1().equals(person.getPassword2());
    }
}