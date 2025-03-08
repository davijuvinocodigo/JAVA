package com.base.inic.common.enums;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

/**
 * Back and forth interactive status code
 *
 * @date 2016/12/8.
 * @author netyjq@gmail.com
 */
@NoArgsConstructor
@Getter
public enum StatusEnum {

    /**
     * request successful
     */
    SUCCESS(HttpStatus.OK.value(), "success"),

    /**
     * business error
     */
    CREATE(HttpStatus.CREATED.value(), "create"),

    /**
     * session expired
     */
    NO_CONTENT(HttpStatus.NO_CONTENT.value(), "no content");

    private int code;
    private String msg;

    StatusEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public StatusEnum buildMessage(String msg) {
        this.msg = msg;
        return this;
    }

    @Override
    public String toString() {
        return msg + "." + this.name() +  ", code:" + code;
    }
}
