//package ra.controller;
//
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import ra.model.domain.ZipCode;
//import ra.model.dto.request.ZipCodeRequestDto;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/zipcode")
//public class ZipCodeController {
//    @PostMapping("/add")
//    public ResponseEntity<ZipCode> addZipcode(@RequestBody ZipCodeRequestDto zipcodeRequestDto) {
//
//    }
//
//    @GetMapping("/get/{id}")
//    public ResponseEntity<ZipCode> getZipcode(@PathVariable  Long id) {
//
//    }
//
//    @GetMapping("/getAll")
//    public ResponseEntity<List<ZipCode>> getZipcodes() {
//
//    }
//
//    @DeleteMapping("/delete/{id}")
//    public ResponseEntity<ZipCode> deleteZipcode(@PathVariable  Long id) {
//
//    }
//
//    @PostMapping("/edit/{id}")
//    public ResponseEntity<ZipCode> editZipcode(@RequestBody  ZipCodeRequestDto zipcodeRequestDto,
//                                               @PathVariable  Long id) {
//
//    }
//
//    @PostMapping("/addCity/{cityId}/toZipcode/{zipcodeId}")
//    public ResponseEntity<ZipCode> addCity(@PathVariable  Long cityId,
//                                           @PathVariable  Long zipcodeId) {
//
//    }
//
//    @PostMapping("/deleteCity/{zipcodeId}")
//    public ResponseEntity<ZipCode> deleteCity(@PathVariable  Long zipcodeId) {
//
//    }
