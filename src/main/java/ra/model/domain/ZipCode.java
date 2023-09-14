package ra.model.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ZipCode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="city_id")
    private City city;
    @OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY,mappedBy="zipcode")
    private List<Author> authors = new ArrayList<>();
}
