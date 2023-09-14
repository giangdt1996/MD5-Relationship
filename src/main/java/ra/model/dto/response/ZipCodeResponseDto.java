package ra.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ra.model.domain.City;

import javax.persistence.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ZipCodeResponseDto {

    private Long id;

    private String name;
    private City city;
}