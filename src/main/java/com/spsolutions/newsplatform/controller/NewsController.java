package com.spsolutions.newsplatform.controller;

import com.spsolutions.newsplatform.dto.request.NewsAddRequestDTO;
import com.spsolutions.newsplatform.dto.response.NewsResponseDTO;
import com.spsolutions.newsplatform.service.NewsService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/news")
public class NewsController {
    private final NewsService newsService;

    @PostMapping
    public ResponseEntity<NewsResponseDTO> addNews(@Valid @RequestBody NewsAddRequestDTO requestDTO) {

        NewsResponseDTO responseDTO = newsService.addNews(requestDTO);
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<NewsResponseDTO> getNewsById(@PathVariable Long id) {

        NewsResponseDTO responseDTO = newsService.getNewsById(id);
        return ResponseEntity.ok(responseDTO);
    }

    @GetMapping
    public ResponseEntity<List<NewsResponseDTO>> getAllNews() {

        List<NewsResponseDTO> responseDTOList = newsService.getAllNews();
        return ResponseEntity.ok(responseDTOList);
    }
}
