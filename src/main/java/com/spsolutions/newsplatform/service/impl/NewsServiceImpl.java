package com.spsolutions.newsplatform.service.impl;

import com.spsolutions.newsplatform.dto.request.NewsAddRequestDTO;
import com.spsolutions.newsplatform.dto.response.NewsResponseDTO;
import com.spsolutions.newsplatform.entity.Category;
import com.spsolutions.newsplatform.entity.News;
import com.spsolutions.newsplatform.exception.DuplicateResourceException;
import com.spsolutions.newsplatform.exception.ResourceNotFoundException;
import com.spsolutions.newsplatform.mapper.NewsMapper;
import com.spsolutions.newsplatform.repository.CategoryRepository;
import com.spsolutions.newsplatform.repository.NewsRepository;
import com.spsolutions.newsplatform.service.NewsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class NewsServiceImpl implements NewsService {

    private final NewsRepository newsRepository;
    private final CategoryRepository categoryRepository;
    private final NewsMapper newsMapper;

    @Override
    public NewsResponseDTO addNews(NewsAddRequestDTO requestDTO) {
        if (newsRepository.existsByHeadline(requestDTO.getHeadline())) {
            throw new DuplicateResourceException("News headline already exists");
        }

        Set<Category> categories = categoryRepository
                .findAllById(requestDTO.getCategoryIds())
                .stream()
                .collect(Collectors.toSet());

        if (categories.size() != requestDTO.getCategoryIds().size()) {
            throw new ResourceNotFoundException("One or more categories not found");
        }

        News news = newsMapper.toEntity(requestDTO, categories);
        News savedNews = newsRepository.save(news);
        return newsMapper.toResponseDTO(savedNews);
    }

    @Override
    public NewsResponseDTO getNewsById(Long id) {
        News news = newsRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("News not found with ID: " + id)
                );

        return newsMapper.toResponseDTO(news);
    }

    @Override
    public List<NewsResponseDTO> getAllNews() {
        return newsRepository.findAll()
                .stream()
                .map(newsMapper::toResponseDTO)
                .toList();
    }
}
