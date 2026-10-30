package com.spsolutions.newsplatform.service;

import com.spsolutions.newsplatform.dto.request.CategoryAddRequestDTO;
import com.spsolutions.newsplatform.dto.response.CategoryResponseDTO;

import java.util.List;

public interface CategoryService {
    CategoryResponseDTO addCategory(CategoryAddRequestDTO requestDTO);
    CategoryResponseDTO getCategoryById(Long id);
    List<CategoryResponseDTO> getAllCategory();
}
