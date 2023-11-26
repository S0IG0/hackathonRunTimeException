package com.hahaton.backend.repository;

import com.hahaton.backend.model.objects.Request;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequestRepository extends JpaRepository<Request, Long> {
}
