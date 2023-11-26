package com.hahaton.backend.service;


import com.hahaton.backend.dto.comment.CommentDto;
import com.hahaton.backend.dto.comment.NewCommentDto;
import com.hahaton.backend.exception.ConflictException;
import com.hahaton.backend.exception.NotFoundException;
import com.hahaton.backend.mapper.CommentMapper;
import com.hahaton.backend.model.objects.Comment;
import com.hahaton.backend.model.role.User;
import com.hahaton.backend.repository.CommentRepository;
import com.hahaton.backend.repository.UserRepository;
import jakarta.validation.ConstraintViolationException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;
    private final UserRepository userRepository;

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

    @Override
    public CommentDto addCommentToNews(NewCommentDto newCommentDto, Long newsId, Long userId) {
        try {
            User user = userRepository.findById(userId).orElseThrow(
                    () -> new NotFoundException("no such user")
            );
            Comment comment = CommentMapper.toComment(newCommentDto, user);
            comment.setNewsId(newsId);
            CommentDto savedComment = CommentMapper.toDto(commentRepository.save(comment));
            log.info("Comment created: {}", savedComment);
            return savedComment;
        } catch (ConstraintViolationException | DataIntegrityViolationException e) {
            throw new ConflictException(e.getMessage());
        }
    }

    @Override
    public CommentDto addCommentToEvent(NewCommentDto newCommentDto, Long eventId, Long userId) {
        try {
            User user = userRepository.findById(userId).orElseThrow(
                    () -> new NotFoundException("no such user")
            );
            Comment comment = CommentMapper.toComment(newCommentDto, user);
            comment.setEventId(eventId);
            CommentDto savedComment = CommentMapper.toDto(commentRepository.save(comment));
            log.info("Comment created: {}", savedComment);
            return savedComment;
        } catch (ConstraintViolationException | DataIntegrityViolationException e) {
            throw new ConflictException(e.getMessage());
        }
    }

    @Override
    public CommentDto addCommentToRequest(NewCommentDto newCommentDto, Long requestId, Long userId) {
        try {
            User user = userRepository.findById(userId).orElseThrow(
                    () -> new NotFoundException("no such user")
            );
            Comment comment = CommentMapper.toComment(newCommentDto, user);
            comment.setRequestId(requestId);
            CommentDto savedComment = CommentMapper.toDto(commentRepository.save(comment));
            log.info("Comment created: {}", savedComment);
            return savedComment;
        } catch (ConstraintViolationException | DataIntegrityViolationException e) {
            throw new ConflictException(e.getMessage());
        }
    }
}
