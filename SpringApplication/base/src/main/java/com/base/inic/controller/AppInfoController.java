package com.base.inic.controller;

import com.base.inic.common.exception.BadRequestAlertException;
import com.base.inic.common.util.HeaderUtil;
import com.base.inic.service.impl.AppInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.base.inic.model.domain.AppInfo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import jakarta.annotation.Resource;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import static org.hibernate.id.IdentifierGenerator.ENTITY_NAME;

/**
 * rest example controller
 *
 * @author netyjq@@gmail.com
 * @date 2017/7/5
 */
@RestController
@Api(tags = "AppInfo")
public class AppInfoController {

    private final Logger log = LoggerFactory.getLogger(AppInfoController.class);

    @Resource
    private AppInfoService appInfoService;


    /**
     * POST  /AppInfo : Create a new appInfo.
     *
     * @param appInfo the customer to create
     * @return the ResponseEntity with status 201 (Created) and with body the new appinfo, or with status 400 (Bad Request) if the customer has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @ApiOperation(value = "create", notes = "create example")
    @RequestMapping(value = "/appinfo", method = RequestMethod.POST)
    public ResponseEntity<AppInfo> createAppInfo(@RequestBody AppInfo appInfo) throws URISyntaxException {
        log.debug("REST request to save AppInfo : {}", appInfo);
        if (appInfo.getId() != null) {
            throw new BadRequestAlertException("A new appInfo cannot already have an ID", ENTITY_NAME, "idexists");
        }
        AppInfo result = appInfoService.save(appInfo);
        return ResponseEntity.created(new URI("/appinfo/" + result.getId()))
                .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
                .body(result);

    }

    @ApiOperation(value = "Get", notes = "Get example")
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public ResponseEntity<List<AppInfo>> getAllAppInfos() {
        log.debug("REST request to get a page of AppInfos");
        try {
            List<AppInfo> appInfoList = appInfoService.findAll();
            return new ResponseEntity<>(appInfoList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
