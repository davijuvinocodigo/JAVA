package com.base.inic.model.dto;


/**
 * abstract DTO class, only with a method validate() used to validate parameters.
 * @author netyjq@gmail.com
 * @date 2019-04-29
 */
public abstract class AbstractDTO {

    /**
     * Validação de parâmetros
     * @return boolean
     */
    public abstract boolean validate();

}
