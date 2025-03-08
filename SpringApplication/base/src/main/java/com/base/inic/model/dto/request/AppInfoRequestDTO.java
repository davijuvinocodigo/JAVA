package com.base.inic.model.dto.request;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import jakarta.validation.constraints.NotNull;

import com.base.inic.common.validation.ValidationMarker;

/**
 * AppInfo RequestDTO Example
 * @date 2017/7/30
 * @author netyjq@gamil.com
 */
@Data
@RequiredArgsConstructor
@ToString 
@EqualsAndHashCode(callSuper = false)
public class AppInfoRequestDTO extends PageRequestDTO {

    @NotNull(groups = {ValidationMarker.UpdateGroup.class})
    private Integer id;

    @NotNull(groups = {ValidationMarker.InsertGroup.class, ValidationMarker.UpdateGroup.class})
    private String name;

    @Override
    public boolean validate() {
        return true;
    }
}
