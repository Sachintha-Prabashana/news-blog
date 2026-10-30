package com.spsolutions.newsplatform.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CommentAddRequestDTO {

    @NotBlank(message = "Comment content must not be blank")
    private String content;

    @NotBlank(message = "Author name must not be blank")
    private String authorName;
}