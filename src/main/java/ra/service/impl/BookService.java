package ra.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.model.domain.Book;

import ra.model.dto.request.BookRequestDto;
import ra.model.dto.response.BookResponseDto;
import ra.model.dto.response.BookResponseDto;
import ra.repository.IAuthorRepository;
import ra.repository.IBookRepository;
import ra.service.IGenericService;

import ra.service.mapper.BookMapper;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookService implements IGenericService<BookResponseDto, BookRequestDto,Long> {
    @Autowired
    private IBookRepository bookRepository;
    @Autowired
    private BookMapper bookMapper;
    @Override
    public List<BookResponseDto> findAll() {
        return bookRepository.findAll().stream()
                .map(c->bookMapper.toResponse(c)).collect(Collectors.toList());
    }

    @Override
    public BookResponseDto findById(Long id) {
        Optional<Book> bookOptional = bookRepository.findById(id);
        if(bookOptional.isPresent()) {
            return bookMapper.toResponse(bookOptional.get());
        }
        return null;
    }

    @Override
    public BookResponseDto save(BookRequestDto bookRequestDto) {
//        if(bookRepository.existsByEmail(bookRequestDto.getEmail())){
//                throw new UserException("Email is existed");
//        }
//        if(bookRepository.existsByPhoneNumber(bookRequestDto.getPhoneNumber())){
//            throw new UserException("Phone is existed");
//        }

        Book cus = bookRepository.save(bookMapper.toEntity(bookRequestDto));
        return bookMapper.toResponse(cus);
    }

    @Override
    public BookResponseDto update(BookRequestDto bookRequestDto, Long id) {
        Book Book = bookMapper.toEntity(bookRequestDto);
        Book.setId(id);
        Book cusEdit = bookRepository.save(Book);
        return bookMapper.toResponse(cusEdit);
    }

    @Override
    public BookResponseDto delete(Long id) {
        Optional<Book> bookOptional = bookRepository.findById(id);
        bookRepository.delete(bookOptional.get());
        if(bookOptional.isPresent()) {
            return bookMapper.toResponse(bookOptional.get());
        }
        return null;
    }
}
