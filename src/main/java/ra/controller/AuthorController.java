package ra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ra.model.dto.request.AuthorRequestDto;
import ra.model.dto.response.AuthorResponseDto;
import ra.service.IGenericService;
import ra.service.impl.AuthorService;

import java.util.List;

@RestController
@RequestMapping ("/author")
public class AuthorController {
    @Autowired
    private AuthorService authorService;

    @PostMapping("/addAuthor")
    public ResponseEntity<AuthorResponseDto> addAuthor(@RequestBody  AuthorRequestDto authorRequestDto) {
        return new ResponseEntity<>(authorService.save(authorRequestDto),HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<AuthorResponseDto> getAuthor(@PathVariable  Long id) {
        return new ResponseEntity<>(authorService.findById(id), HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<AuthorResponseDto>> getAuthors() {
        return new ResponseEntity<>(authorService.findAll(), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<AuthorResponseDto> deleteAuthor(@PathVariable  Long id) {

            return new ResponseEntity<>(authorService.delete(id),HttpStatus.OK);
        }



    @PostMapping("/edit/{id}")
    private ResponseEntity<AuthorResponseDto> editAuthor(@PathVariable  Long id,
                                                         @RequestBody  AuthorRequestDto authorRequestDto) {
        return new ResponseEntity<>(authorService.update(authorRequestDto,id),HttpStatus.OK);

    }

//    @PostMapping("/addZipcode/{zipcodeId}/to/{authorId}")
//    private ResponseEntity<AuthorResponseDto> addZipcode(@PathVariable  Long zipcodeId,
//                                                         @PathVariable  Long authorId) {
//    }
//
//    @PostMapping("/removeZipcode/{id}")
//    private ResponseEntity<AuthorResponseDto> removeZipcode(@PathVariable  Long id) {
//
//    }
}
