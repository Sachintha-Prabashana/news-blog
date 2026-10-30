package com.spsolutions.newsplatform.controller;

import com.spsolutions.newsplatform.dto.request.CommentAddRequestDTO;
import com.spsolutions.newsplatform.service.CommentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequiredArgsConstructor
@RequestMapping("/comments")
public class CommentController {

    private final CommentService commentService;

    @PostMapping
    public ResponseEntity<Void> addComment(@PathVariable Long newsId, @Valid @RequestBody CommentAddRequestDTO requestDTO
    ) {
        commentService.addComment(newsId, requestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
