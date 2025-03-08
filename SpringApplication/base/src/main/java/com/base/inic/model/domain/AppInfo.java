package com.base.inic.model.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

/**
 * entity exemplo
 * @author yejq@gmail.com
 * @date 2019-06-05
 */
@Data
@RequiredArgsConstructor
@ToString 
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "AppInfo")
public class AppInfo{

    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * Nome da Aplicação
     */
    private String name;

}
