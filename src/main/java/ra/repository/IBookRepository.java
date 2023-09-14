package ra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ra.model.domain.Book;

@Repository
public interface IBookRepository extends JpaRepository<Book,Long> {
}
