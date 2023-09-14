//package ra.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import ra.model.domain.City;
//import ra.model.dto.request.CityRequestDto;
//import ra.model.dto.response.CityResponseDto;
//import ra.service.impl.CityService;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/city")
//public class CityController {
//@Autowired
//private CityService cityService;
//    @PostMapping("/add")
//    public ResponseEntity<CityResponseDto> addCity(@RequestBody CityRequestDto cityRequestDto) {
//        return new ResponseEntity<>( cityService.save(cityRequestDto), HttpStatus.OK);
//    }
//
//    @GetMapping("/get/{id}")
//    public ResponseEntity<City> getCityById(@PathVariable  Long id) {
//
//    }
//
//    @GetMapping("/getall")
//    public ResponseEntity<List<City>> getCities() {
//
//    }
//
//    @DeleteMapping("/delete/{id}")
//    public ResponseEntity<City> deleteCity(@PathVariable  Long id) {
//
//    }
//
//    @PostMapping("/edit/id")
//    public ResponseEntity<City> editCity(@RequestBody  CityRequestDto cityRequestDto,
//                                         @PathVariable  Long id) {
//
//    }
//}
