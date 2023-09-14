package ra.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ra.model.domain.Author;
import ra.model.domain.Category;

import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookResponseDto {
    private Long id;

    private String name;

    private Category category;

    private Set<Author> authors = new HashSet<>();

}
