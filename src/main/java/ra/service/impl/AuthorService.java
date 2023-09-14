package ra.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.model.domain.Author;
import ra.model.dto.request.AuthorRequestDto;
import ra.model.dto.response.AuthorResponseDto;
import ra.repository.IAuthorRepository;
import ra.service.IGenericService;
import ra.service.mapper.AuthorMapper;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AuthorService implements IGenericService<AuthorResponseDto, AuthorRequestDto,Long> {
   @Autowired
   private IAuthorRepository authorRepository;
   @Autowired
   private AuthorMapper authorMapper;

    @Override
    public List<AuthorResponseDto> findAll() {
        return authorRepository.findAll().stream()
             .map(c->authorMapper.toResponse(c)).collect(Collectors.toList());
    }

    @Override
    public AuthorResponseDto findById(Long id) {
        Optional<Author> authorOptional = authorRepository.findById(id);
       if(authorOptional.isPresent()) {
           return authorMapper.toResponse(authorOptional.get());
       }
       return null;
    }

    @Override
    public AuthorResponseDto save(AuthorRequestDto authorRequestDto) {
//        if(authorRepository.existsByEmail(authorRequestDto.getEmail())){
//                throw new UserException("Email is existed");
//        }
//        if(authorRepository.existsByPhoneNumber(authorRequestDto.getPhoneNumber())){
//            throw new UserException("Phone is existed");
//        }

        Author cus = authorRepository.save(authorMapper.toEntity(authorRequestDto));
        return authorMapper.toResponse(cus);
    }

    @Override
    public AuthorResponseDto update(AuthorRequestDto authorRequestDto, Long id) {
        Author Author = authorMapper.toEntity(authorRequestDto);
        Author.setId(id);
        Author cusEdit = authorRepository.save(Author);
        return authorMapper.toResponse(cusEdit);
    }

    @Override
    public AuthorResponseDto delete(Long id) {
        Optional<Author> authorOptional = authorRepository.findById(id);
        authorRepository.delete(authorOptional.get());
        if(authorOptional.isPresent()) {
            return authorMapper.toResponse(authorOptional.get());
        }
        return null;
    }
}
