package com.spsolutions.newsplatform.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NewsUpdateRequestDTO {

    @NotBlank(message = "Headline must not be blank")
    private String headline;

    @NotBlank(message = "Description must not be blank")
    private String description;

    @NotEmpty(message = "At least one category must be selected")
    private Set<Long> categoryIds;
}