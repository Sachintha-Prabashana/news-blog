package com.spsolutions.newsplatform.service.impl;

import com.spsolutions.newsplatform.dto.request.CategoryAddRequestDTO;
import com.spsolutions.newsplatform.dto.response.CategoryResponseDTO;
import com.spsolutions.newsplatform.entity.Category;
import com.spsolutions.newsplatform.exception.DuplicateResourceException;
import com.spsolutions.newsplatform.exception.ResourceNotFoundException;
import com.spsolutions.newsplatform.mapper.CategoryMapper;
import com.spsolutions.newsplatform.repository.CategoryRepository;
import com.spsolutions.newsplatform.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    @Override
    public CategoryResponseDTO addCategory(CategoryAddRequestDTO requestDTO) {
        if (categoryRepository.existsByName(requestDTO.getName())) {
            throw new DuplicateResourceException("Category already exists");
        }

        Category category = categoryMapper.toEntity(requestDTO);
        Category savedCategory = categoryRepository.save(category);
        return categoryMapper.toResponseDTO(savedCategory);
    }

    @Override
    public CategoryResponseDTO getCategoryById(Long id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Category not found with ID: " + id)
                );

        return categoryMapper.toResponseDTO(category);
    }

    @Override
    public List<CategoryResponseDTO> getAllCategory() {
        return categoryRepository.findAll()
                .stream()
                .map(categoryMapper::toResponseDTO)
                .toList();
    }
}
