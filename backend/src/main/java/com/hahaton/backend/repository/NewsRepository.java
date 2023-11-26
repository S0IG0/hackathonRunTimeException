package com.hahaton.backend.repository;

import com.hahaton.backend.model.Category;
import com.hahaton.backend.model.objects.News;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NewsRepository extends JpaRepository<News, Long> {

    List<News> findAllByCategory(Category category, PageRequest pageRequest);
}
