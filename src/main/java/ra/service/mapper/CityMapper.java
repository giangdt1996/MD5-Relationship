package ra.service.mapper;

import org.springframework.stereotype.Component;
import ra.model.domain.City;
import ra.model.dto.request.CityRequestDto;
import ra.model.dto.response.CategoryResponseDto;
import ra.model.dto.response.CityResponseDto;
import ra.service.IGenericMapper;

@Component
public class CityMapper implements IGenericMapper<City, CityRequestDto, CityResponseDto> {
    @Override
    public City toEntity(CityRequestDto cityRequestDto) {
        return City.builder().name(cityRequestDto.getName()).build();
    }

    @Override
    public CityResponseDto toResponse(City city) {
        return CityResponseDto.builder()
                .id(city.getId())
                .name(city.getName()).build();
    }
}
