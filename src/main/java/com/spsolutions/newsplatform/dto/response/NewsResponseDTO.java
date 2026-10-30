package com.spsolutions.newsplatform.dto.response;

import lombok.*;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NewsResponseDTO {
    private Long id;
    private String headline;
    private String description;

    private Set<CategoryResponseDTO> categories;
    private List<CommentResponseDTO> comments;
}
