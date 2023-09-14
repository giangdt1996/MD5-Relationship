package ra.service.mapper;

import org.springframework.stereotype.Component;
import ra.model.domain.Book;
import ra.model.dto.request.BookRequestDto;
import ra.model.dto.response.BookResponseDto;
import ra.service.IGenericMapper;

@Component
public class BookMapper implements IGenericMapper<Book, BookRequestDto, BookResponseDto> {
    @Override
    public Book toEntity(BookRequestDto bookRequestDto) {
        return Book.builder()
                .name(bookRequestDto.getName())
                .category(bookRequestDto.getCategory())
                .authors(bookRequestDto.getAuthors())
                .build();
    }

    @Override
    public BookResponseDto toResponse(Book book) {
        return BookResponseDto.builder()
                .id(book.getId())
                .name(book.getName())
                .category(book.getCategory())
                .authors(book.getAuthors())
                .build();
    }
}
