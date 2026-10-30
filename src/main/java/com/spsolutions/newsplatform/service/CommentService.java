package com.spsolutions.newsplatform.service;

import com.spsolutions.newsplatform.dto.request.CommentAddRequestDTO;

public interface CommentService {

    void addComment(Long newsId, CommentAddRequestDTO requestDTO);
}
