package pl.ztrzaska.rental.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.ztrzaska.rental.entity.ObjectForRent;

@Repository
public interface ObjectForRentalRepository extends JpaRepository<ObjectForRent, Long> {
}
