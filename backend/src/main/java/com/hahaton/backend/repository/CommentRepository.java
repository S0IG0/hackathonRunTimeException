package com.hahaton.backend.repository;

import com.hahaton.backend.model.objects.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
