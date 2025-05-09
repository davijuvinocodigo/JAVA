package com.base.inic.common.validation;


import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import com.base.inic.common.exception.ParamInvalidException;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import java.util.List;
import java.util.Set;

/**
 * Hibernate validator
 *
 * @date 2017/6/5
 * @author netyjq@gmail.com
 */
public class MyValidator {

    /**
     * 验证前端参数,有错误直接抛出异常
     * @param result BindResult
     * @throws ParamInvalidException  参数异常
     * @return
     */
    public static void validateBindResult(BindingResult result) throws ParamInvalidException {
        if (result !=null && result.hasErrors()) {
            List<FieldError> errors = result.getFieldErrors();
            for (FieldError error : errors) {
                throw new ParamInvalidException(error.getField(), error.getDefaultMessage());
            }
        }
    }

    /**
     * Hibernate MyValidator 验证器
     * @param object 需要校验的对象
     * @throws ParamInvalidException 参数异常
     */
    public static void validate(Object object) throws ParamInvalidException {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<Object>> constraintViolations = validator.validate(object);
        for (ConstraintViolation<Object> constraintViolation : constraintViolations) {
            throw new ParamInvalidException(constraintViolation.getPropertyPath().toString(), constraintViolation.getMessage());
        }
    }
}
