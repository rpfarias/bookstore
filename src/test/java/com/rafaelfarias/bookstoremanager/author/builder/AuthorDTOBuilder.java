package com.rafaelfarias.bookstoremanager.author.builder;

import com.rafaelfarias.bookstoremanager.author.dto.AuthorDTO;
import lombok.Builder;

@Builder
public class AuthorDTOBuilder {

    @Builder.Default
    private final Long id = 1L;

    @Builder.Default
    private final String name = "Rafael Farias";

    @Builder.Default
    private final Integer age = 35;

    public AuthorDTO buildAuthorDTO() {
        return new AuthorDTO(id, name, age);
    }
}
