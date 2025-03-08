package com.base.inic.common.exception;

import com.base.inic.common.enums.ErrorEnum;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

/**
 * parameter invalid error
 *
 * @author netyjq@gmail.com
 * @date 2019-04-28
 */
@Data
@RequiredArgsConstructor
@ToString 
@EqualsAndHashCode(callSuper = false)
public class ParamInvalidException extends AbstractException {

    private String field;

    @Override
    String buildErrorMessage() {
        return ErrorEnum.WEB_PARAM_ERROR.buildMessage(this.getMessage()).toString();
    }

    public ParamInvalidException(String field, String message) {
        super("parameter: " + field + message);
        this.field = field;
    }

}
