package com.rafaelfarias.bookstoremanager.author.mapper;

import com.rafaelfarias.bookstoremanager.author.dto.AuthorDTO;
import com.rafaelfarias.bookstoremanager.author.entity.Author;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AuthorMapper {

    AuthorMapper INSTANCE = Mappers.getMapper(AuthorMapper.class);

    Author toModel(AuthorDTO authorDTO); // converte DTO para uma entidade

    AuthorDTO toDTO(Author author); // converte entidade para um DTO
}
