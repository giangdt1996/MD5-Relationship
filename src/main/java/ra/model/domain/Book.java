package ra.model.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder

    public class Book {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        @Column(name = "name")
        private String name;
        @ManyToOne
        @JoinColumn(name = "category_id")
        private Category category;

    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "books")
    private List<Author> authors = new ArrayList<>();

}