package pl.ztrzaska.rental.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.ztrzaska.rental.entity.Renter;

@Repository
public interface RenterRepository extends JpaRepository<Renter, Long> {
}
