package ra.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.model.domain.ZipCode;

import ra.model.dto.request.ZipCodeRequestDto;
import ra.model.dto.response.ZipCodeResponseDto;
import ra.repository.IZipCodeRepository;
import ra.service.IGenericService;
import ra.service.mapper.ZipCodeMapper;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ZipCodeService  implements IGenericService<ZipCodeResponseDto, ZipCodeRequestDto,Long> {
   @Autowired
   private IZipCodeRepository zipCodeRepository;
   @Autowired
   private ZipCodeMapper zipCodeMapper;
    @Override
    public List<ZipCodeResponseDto> findAll() {
        return zipCodeRepository.findAll().stream()
                .map(c->zipCodeMapper.toResponse(c)).collect(Collectors.toList());
    }

    @Override
    public ZipCodeResponseDto findById(Long id) {
        Optional<ZipCode> bookOptional = zipCodeRepository.findById(id);
        if(bookOptional.isPresent()) {
            return zipCodeMapper.toResponse(bookOptional.get());
        }
        return null;
    }

    @Override
    public ZipCodeResponseDto save(ZipCodeRequestDto zipCodeRequestDto) {
        ZipCode cus = zipCodeRepository.save(zipCodeMapper.toEntity(zipCodeRequestDto));
        return zipCodeMapper.toResponse(cus);
    }

    @Override
    public ZipCodeResponseDto update(ZipCodeRequestDto zipCodeRequestDto, Long id) {
        ZipCode ZipCode = zipCodeMapper.toEntity(zipCodeRequestDto);
        ZipCode.setId(id);
        ZipCode cusEdit = zipCodeRepository.save(ZipCode);
        return zipCodeMapper.toResponse(cusEdit);
    }

    @Override
    public ZipCodeResponseDto delete(Long id) {
        Optional<ZipCode> bookOptional = zipCodeRepository.findById(id);
        zipCodeRepository.delete(bookOptional.get());
        if(bookOptional.isPresent()) {
            return zipCodeMapper.toResponse(bookOptional.get());
        }
        return null;
    }
}
