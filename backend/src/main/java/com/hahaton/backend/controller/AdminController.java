package com.hahaton.backend.controller;


import com.hahaton.backend.dto.organization.NewOrganizationDto;
import com.hahaton.backend.dto.organization.OrganizationDto;
import com.hahaton.backend.service.OrganizationService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
@Slf4j
@RequestMapping(path = "/admin")
@AllArgsConstructor
public class AdminController {
    private final OrganizationService organizationService;

    @PostMapping("/register-organization")
    ResponseEntity<OrganizationDto> createOrganization(@RequestBody @Validated NewOrganizationDto newOrganizationDto) {
        log.info("Organization post accepted: {}", newOrganizationDto);
        return new ResponseEntity<>(organizationService.postOrganization(newOrganizationDto), HttpStatus.CREATED);
    }

}
