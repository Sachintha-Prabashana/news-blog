package com.spsolutions.newsplatform.controller;

import com.spsolutions.newsplatform.dto.request.CategoryAddRequestDTO;
import com.spsolutions.newsplatform.dto.response.CategoryResponseDTO;
import com.spsolutions.newsplatform.service.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<CategoryResponseDTO>> getAllCategory() {

        List<CategoryResponseDTO> responseDTOList = categoryService.getAllCategory();
        return ResponseEntity.ok(responseDTOList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponseDTO> getCategoryById(Long id) {
        CategoryResponseDTO responseDTO = categoryService.getCategoryById(id);
        return ResponseEntity.ok(responseDTO);
    }

    @PostMapping
    public ResponseEntity<CategoryResponseDTO> createCategory(@Valid @RequestBody CategoryAddRequestDTO dto) {
        return new ResponseEntity<>(categoryService.addCategory(dto), HttpStatus.CREATED);
    }
}
