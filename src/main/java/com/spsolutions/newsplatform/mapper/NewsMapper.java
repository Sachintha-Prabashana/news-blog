package com.spsolutions.newsplatform.mapper;

import com.spsolutions.newsplatform.dto.request.NewsAddRequestDTO;
import com.spsolutions.newsplatform.dto.response.NewsResponseDTO;
import com.spsolutions.newsplatform.entity.Category;
import com.spsolutions.newsplatform.entity.News;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class NewsMapper {
    private final CategoryMapper categoryMapper;
    private final CommentMapper commentMapper;

    public News toEntity(NewsAddRequestDTO requestDTO, Set<Category> categories) {

        return News.builder()
                .headline(requestDTO.getHeadline())
                .description(requestDTO.getDescription())
                .categories(categories)
                .build();
    }

    public NewsResponseDTO toResponseDTO(News news) {

        return NewsResponseDTO.builder()
                .id(news.getId())
                .headline(news.getHeadline())
                .description(news.getDescription())
                .categories(
                        news.getCategories().stream()
                                .map(categoryMapper::toResponseDTO)
                                .collect(Collectors.toSet())
                )
                .comments(
                news.getComments()
                        .stream()
                        .map(commentMapper::toResponseDTO)
                        .toList()
                )
                .build();
    }



}
