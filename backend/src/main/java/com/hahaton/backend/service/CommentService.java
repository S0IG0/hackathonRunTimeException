package com.hahaton.backend.service;

import com.hahaton.backend.dto.comment.CommentDto;
import com.hahaton.backend.dto.comment.NewCommentDto;

import java.util.List;

public interface CommentService {

    List<CommentDto> getNewsComments (Long newsId);
    CommentDto addCommentToNews(NewCommentDto newCommentDto, Long newsId, Long userId);
    CommentDto addCommentToEvent(NewCommentDto newCommentDto, Long eventId, Long userId);
    CommentDto addCommentToRequest(NewCommentDto newCommentDto, Long requestId, Long userId);

}
