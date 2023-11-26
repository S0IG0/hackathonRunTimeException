package com.hahaton.backend.dto.request;

import com.hahaton.backend.dto.comment.CommentDto;
import com.hahaton.backend.dto.organization.OrganizationShortDto;
import com.hahaton.backend.dto.response.ResponseDto;
import com.hahaton.backend.dto.user.UserShortDto;
import com.hahaton.backend.model.status.RequestStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RequestDto {
    public static final String DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";

    private Long id;

    @NotBlank(message = "title may not be blank or null")
    @Size(max = 254, min = 1)
    private String title;

    @NotBlank(message = "request may not be blank or null")
    @Size(max = 254, min = 1)
    private String text;

    private UserShortDto initiator;
    private OrganizationShortDto receiver;

    @DateTimeFormat(pattern = DATE_TIME_PATTERN)
    private String date;

    private RequestStatus status;

    private byte[] picture;

    private List<CommentDto> comments;

    private List<ResponseDto> responses;

}
