package ra.service.mapper;

import org.springframework.stereotype.Component;
import ra.model.domain.ZipCode;
import ra.model.dto.request.ZipCodeRequestDto;
import ra.model.dto.response.ZipCodeResponseDto;
import ra.service.IGenericMapper;

@Component
public class ZipCodeMapper implements IGenericMapper<ZipCode, ZipCodeRequestDto, ZipCodeResponseDto> {
    @Override
    public ZipCode toEntity(ZipCodeRequestDto zipCodeRequestDto) {
        return ZipCode.builder()
                .name(zipCodeRequestDto.getName())
                .city(zipCodeRequestDto.getCity())
                        .build();
    }

    @Override
    public ZipCodeResponseDto toResponse(ZipCode zipCode) {
        return ZipCodeResponseDto.builder()
                .id(zipCode.getId())
                .name(zipCode.getName())
                .city(zipCode.getCity())
                .build();
    }
}
