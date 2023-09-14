package ra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ra.model.domain.Author;

@Repository
public interface IAuthorRepository extends JpaRepository<Author,Long > {
}
