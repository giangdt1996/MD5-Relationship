package ra.service.mapper;

import org.springframework.stereotype.Component;
import ra.model.domain.Author;
import ra.model.dto.request.AuthorRequestDto;
import ra.model.dto.response.AuthorResponseDto;
import ra.service.IGenericMapper;

@Component
public class AuthorMapper implements IGenericMapper<Author, AuthorRequestDto, AuthorResponseDto> {
    @Override
    public Author toEntity(AuthorRequestDto authorRequestDto) {
        return Author.builder().name(authorRequestDto.getName())
                .zipcode(authorRequestDto.getZipcode())
                .books(authorRequestDto.getBooks())
                .build();
    }

    @Override
    public AuthorResponseDto toResponse(Author author) {
        return AuthorResponseDto.builder().id(author.getId())
                .name(author.getName())
                .zipcode(author.getZipcode())
                .books(author.getBooks())
                .build();
    }
}
