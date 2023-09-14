package ra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ra.model.dto.request.BookRequestDto;
import ra.model.dto.response.BookResponseDto;
import ra.service.impl.BookService;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService bookService;
    @PostMapping("/add")
    public ResponseEntity<BookResponseDto> addBook(@RequestBody BookRequestDto bookRequestDto) {
        return new ResponseEntity<>(bookService.save(bookRequestDto), HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<BookResponseDto> getBook(@PathVariable  Long id) {
        return new ResponseEntity<>(bookService.findById(id), HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<BookResponseDto>> getBooks() {
        return new ResponseEntity<>(bookService.findAll(), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<BookResponseDto> deleteBook(@PathVariable  Long id) {
        return new ResponseEntity<>(bookService.delete(id),HttpStatus.OK);
    }

    @PostMapping("/edit/{id}")
    public ResponseEntity<BookResponseDto> editBook(@RequestBody  BookRequestDto bookRequestDto,
                                                    @PathVariable  Long id) {
        return new ResponseEntity<>(bookService.update(bookRequestDto,id),HttpStatus.OK);
    }

//    @PostMapping("/addCategory/{categoryId}/to/{bookId}")
//    public ResponseEntity<BookResponseDto> addCategory(@PathVariable  Long categoryId,
//                                                       @PathVariable  Long bookId) {
//
//    }
//
//    @PostMapping("/removeCategory/{categoryId}/from/{bookId}")
//    public ResponseEntity<BookResponseDto> removeCategory(@PathVariable  Long categoryId,
//                                                          @PathVariable  Long bookId) {
//    }
//
//    @PostMapping("/addAuthor/{authorId}/to/{bookId}")
//    public ResponseEntity<BookResponseDto> addAuthor(@PathVariable  Long authorId,
//                                                     @PathVariable  Long bookId) {
//    }
//
//    @PostMapping("/removeAuthor/{authorId}/from/{bookId}")
//    public ResponseEntity<BookResponseDto> removeAuthor(@PathVariable  Long authorId,
//                                                        @PathVariable  Long bookId) {
//
//    }
}
