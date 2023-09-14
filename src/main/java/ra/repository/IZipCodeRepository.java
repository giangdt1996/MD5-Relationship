package ra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ra.model.domain.ZipCode;

@Repository
public interface IZipCodeRepository extends JpaRepository<ZipCode,Long> {
}
