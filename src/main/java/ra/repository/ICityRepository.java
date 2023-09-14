package ra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ra.model.domain.City;

@Repository
public interface ICityRepository extends JpaRepository<City,Long> {
}
