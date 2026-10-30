package com.spsolutions.newsplatform.repository;

import com.spsolutions.newsplatform.entity.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewsRepository extends JpaRepository<News, Long> {
    boolean existsByHeadline(String headline);
}
