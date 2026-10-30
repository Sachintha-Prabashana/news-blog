package com.spsolutions.newsplatform.mapper;

import com.spsolutions.newsplatform.dto.request.CommentAddRequestDTO;
import com.spsolutions.newsplatform.dto.response.CommentResponseDTO;
import com.spsolutions.newsplatform.entity.Comment;
import com.spsolutions.newsplatform.entity.News;
import org.springframework.stereotype.Component;

@Component
public class CommentMapper {
    public Comment toEntity(CommentAddRequestDTO requestDTO, News news) {
        return Comment.builder()
                .content(requestDTO.getContent())
                .authorName(requestDTO.getAuthorName())
                .news(news)
                .build();
    }

    public CommentResponseDTO toResponseDTO(Comment comment) {
        return CommentResponseDTO.builder()
                .id(comment.getId())
                .content(comment.getContent())
                .authorName(comment.getAuthorName())
                .build();
    }
}