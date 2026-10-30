package com.spsolutions.newsplatform.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategoryAddRequestDTO {
    @NotBlank(message = "Category name must not be blank")
    private String name;

    private String description;

}
