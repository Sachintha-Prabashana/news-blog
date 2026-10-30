package com.spsolutions.newsplatform.mapper;

import com.spsolutions.newsplatform.dto.request.CategoryAddRequestDTO;
import com.spsolutions.newsplatform.dto.response.CategoryResponseDTO;
import com.spsolutions.newsplatform.entity.Category;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper {
    public Category toEntity(CategoryAddRequestDTO requestDTO) {
        return Category.builder()
                .name(requestDTO.getName())
                .description(requestDTO.getDescription())
                .build();
    }

    public CategoryResponseDTO toResponseDTO(Category category) {
        return CategoryResponseDTO.builder()
                .id(category.getId())
                .name(category.getName())
                .description(category.getDescription())
                .build();
    }
}
