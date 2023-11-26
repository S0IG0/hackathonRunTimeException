package com.hahaton.backend.mapper;

import com.hahaton.backend.dto.comment.CommentDto;
import com.hahaton.backend.dto.organization.OrganizationShortDto;
import com.hahaton.backend.dto.request.NewRequestDto;
import com.hahaton.backend.dto.request.RequestDto;
import com.hahaton.backend.dto.response.ResponseDto;
import com.hahaton.backend.dto.user.UserShortDto;
import com.hahaton.backend.model.objects.Request;
import com.hahaton.backend.model.role.Organization;
import com.hahaton.backend.model.role.User;
import com.hahaton.backend.model.status.RequestStatus;

import java.time.format.DateTimeFormatter;
import java.util.List;

public class RequestMapper {
    private static final String DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";

    public static RequestDto toDto(Request request,
                                   UserShortDto userDto,
                                   OrganizationShortDto organizationDto,
                                   List<CommentDto> comments,
                                   List<ResponseDto> responses,
                                   byte[] data){
        return RequestDto.builder()
                .id(request.getId())
                .title(request.getTitle())
                .text(request.getText())
                .initiator(userDto)
                .receiver(organizationDto)
                .date(request.getRequestDate().format(DateTimeFormatter.ofPattern(DATE_TIME_PATTERN)))
                .status(request.getStatus())
                .comments(comments)
                .responses(responses)
                .picture(data)
                .build();
    }

    public static Request toRequest(NewRequestDto newRequestDto,
                                  User user,
                                  Organization organization,
                                  Long pictureId){
        return Request.builder()
                .title(newRequestDto.getTitle())
                .text(newRequestDto.getText())
                .pictureId(pictureId)
                .status(RequestStatus.WAITING)
                .user(user)
                .organization(organization)
                .build();
    }
}
