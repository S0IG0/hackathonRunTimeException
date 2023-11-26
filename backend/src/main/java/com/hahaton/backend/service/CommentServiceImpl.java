package com.hahaton.backend.service;


import com.hahaton.backend.dto.comment.CommentDto;
import com.hahaton.backend.mapper.CommentMapper;
import com.hahaton.backend.model.objects.Comment;
import com.hahaton.backend.repository.CommentRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;

    @Override
    public List<CommentDto> getNewsComments(Long newsId) {
        List<Comment> comments = commentRepository.findAllByNewsId(newsId);
        List<CommentDto> commentDtos = new ArrayList<>();
        for (Comment comment : comments) {
            commentDtos.add(CommentMapper.toDto(comment));
        }
        log.info("found comments{}", commentDtos);
        return commentDtos;
    }
}
