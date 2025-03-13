package com.techgeeknext.controller;

import com.techgeeknext.model.Organization;
import com.techgeeknext.repository.OrganizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

//@CrossOrigin(origins = "http://localhost:3000") //open for specific port
@CrossOrigin() // open for all ports
@RestController
public class OrganizationController {

    @Autowired
    OrganizationRepository organizationRepository;

    /**
     * Create new organization and assign employees
     *
     * @param organization
     * @return ResponseEntity
     */
    @PostMapping("/org/assign")
    public ResponseEntity<Organization> assignEmpToOrg(@RequestBody Organization organization) {
        return new ResponseEntity<>(
                organizationRepository.save(organization),
                HttpStatus.CREATED);
    }

}
