package ra.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.model.domain.City;

import ra.model.dto.request.CityRequestDto;
import ra.model.dto.response.BookResponseDto;
import ra.model.dto.response.CityResponseDto;
import ra.repository.ICityRepository;
import ra.service.IGenericService;
import ra.service.mapper.CityMapper;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CityService  implements IGenericService<CityResponseDto, CityRequestDto,Long> {
   @Autowired
   private ICityRepository cityRepository;
   @Autowired
   private CityMapper cityMapper;
    @Override
    public List<CityResponseDto> findAll() {
        return cityRepository.findAll().stream()
                .map(c->cityMapper.toResponse(c)).collect(Collectors.toList());
    }

    @Override
    public CityResponseDto findById(Long id) {
        Optional<City> cityOptional = cityRepository.findById(id);
        if(cityOptional.isPresent()) {
            return cityMapper.toResponse(cityOptional.get());
        }
        return null;
    }

    @Override
    public CityResponseDto save(CityRequestDto cityRequestDto) {
        City city = cityRepository.save(cityMapper.toEntity(cityRequestDto));
        return cityMapper.toResponse(city);
    }

    @Override
    public CityResponseDto update(CityRequestDto cityRequestDto, Long id) {
        City City = cityMapper.toEntity(cityRequestDto);
        City.setId(id);
        City cusEdit = cityRepository.save(City);
        return cityMapper.toResponse(cusEdit);
    }

    @Override
    public CityResponseDto delete(Long id) {
        Optional<City> cityOptional = cityRepository.findById(id);
        cityRepository.delete(cityOptional.get());
        if(cityOptional.isPresent()) {
            return cityMapper.toResponse(cityOptional.get());
        }
        return null;
    }
}
