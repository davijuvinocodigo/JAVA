package com.base.inic.common.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

/**
 * @author netyjq@gmail.com
 * @date 2019-04-28
 */
@Data
@RequiredArgsConstructor
@ToString 
@EqualsAndHashCode(callSuper = false)
public abstract class AbstractException extends RuntimeException {

    private String message;

    /**
     * build error message
     * @return String
     */
    abstract String buildErrorMessage();

    public AbstractException(String message) {
        this.message = message;
    }

}
