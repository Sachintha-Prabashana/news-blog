package com.spsolutions.newsplatform.service;

import com.spsolutions.newsplatform.dto.request.NewsAddRequestDTO;
import com.spsolutions.newsplatform.dto.response.NewsResponseDTO;

import java.util.List;

public interface NewsService {
    NewsResponseDTO addNews(NewsAddRequestDTO requestDTO);
    NewsResponseDTO getNewsById(Long id);
    List<NewsResponseDTO> getAllNews();
//    NewsResponseDTO updateNews(Long id, NewsUpdateRequestDTO requestDTO);
}
