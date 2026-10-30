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
public class NewsAddRequestDTO {

    @NotBlank(message = "Headline must not be required")
    private String headline;

    private String description;

    @NotEmpty(message = "At least one category must be selected")
    private Set<Long> categoryIds;
}
