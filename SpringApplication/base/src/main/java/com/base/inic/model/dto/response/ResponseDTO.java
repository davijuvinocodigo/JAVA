package com.base.inic.model.dto.response;

import com.base.inic.common.enums.StatusEnum;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

import com.base.inic.common.enums.ErrorEnum;

/**
 * common-used response class used to return data to browser by spring controllers.
 * @date 2017/2/20.
 * @author netyjq@gmail.com
 */
@Data
public class ResponseDTO {

    /**
     * Código de resposta
     */
    private Integer result;

    /**
     * mensagem de resposta
     */
    private Object message;

    /**
     * dados de resposta
     */
    private Object data;

    public ResponseDTO() {
        this.result = ErrorEnum.SUCCESS.getCode();
        this.message = ErrorEnum.SUCCESS.getMsg();
    }

    public ResponseDTO(StatusEnum statusEnum) {
        this.result = statusEnum.getCode();
        this.message = statusEnum.getMsg();
    }

    public ResponseDTO(ErrorEnum errorEnum) {
        this.result = errorEnum.getCode();
        this.message = errorEnum.getMsg();
    }

    public ResponseDTO(Object object, StatusEnum statusEnum) {
        this.data = object;
        this.result = statusEnum.getCode();
        this.message = statusEnum.getMsg();
    }

    public ResponseDTO(Object object) {
        this.data = object;
        this.result = ErrorEnum.SUCCESS.getCode();
        this.message = ErrorEnum.SUCCESS.getMsg();
    }

    public ResponseDTO(Object object, String key) {
        Map<String, Object> map = new HashMap<>();
        map.put(key, object);
        this.data = map;
        this.result = ErrorEnum.SUCCESS.getCode();
        this.message = ErrorEnum.SUCCESS.getMsg();
    }

}
