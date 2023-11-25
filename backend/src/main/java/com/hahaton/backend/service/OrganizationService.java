package com.hahaton.backend.service;

import com.hahaton.backend.dto.organization.NewOrganizationDto;
import com.hahaton.backend.dto.organization.OrganizationDto;

public interface OrganizationService {

    OrganizationDto postOrganization(NewOrganizationDto newOrganizationDto);


}
