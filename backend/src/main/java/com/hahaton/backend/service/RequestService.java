package com.hahaton.backend.service;

import com.hahaton.backend.dto.request.NewRequestDto;
import com.hahaton.backend.dto.request.RequestDto;

public interface RequestService {
    RequestDto postRequest(NewRequestDto newRequestDto, Long userId, Long organizationId, Long pictureId);
}
