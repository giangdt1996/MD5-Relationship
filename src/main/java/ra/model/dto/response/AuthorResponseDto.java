package ra.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ra.model.domain.Book;
import ra.model.domain.ZipCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuthorResponseDto {
    private Long id;
    private String name;
    private ZipCode zipcode;
    private List<Book> books = new ArrayList<>();
}
