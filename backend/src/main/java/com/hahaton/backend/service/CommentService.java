package com.hahaton.backend.service;

import com.hahaton.backend.dto.comment.CommentDto;

import java.util.List;

public interface CommentService {

    List<CommentDto> getNewsComments (Long newsId);
}
