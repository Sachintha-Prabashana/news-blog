package com.spsolutions.newsplatform.service.impl;

import com.spsolutions.newsplatform.dto.request.CommentAddRequestDTO;
import com.spsolutions.newsplatform.entity.Comment;
import com.spsolutions.newsplatform.entity.News;
import com.spsolutions.newsplatform.exception.ResourceNotFoundException;
import com.spsolutions.newsplatform.mapper.CommentMapper;
import com.spsolutions.newsplatform.repository.CommentRepository;
import com.spsolutions.newsplatform.repository.NewsRepository;
import com.spsolutions.newsplatform.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final NewsRepository newsRepository;
    private final CommentMapper commentMapper;


    @Override
    public void addComment(Long newsId, CommentAddRequestDTO requestDTO) {

        News news = newsRepository.findById(newsId)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "News not found with ID: " + newsId
                        )
                );

        Comment comment = commentMapper.toEntity(requestDTO, news);
        commentRepository.save(comment);
    }
}