package pl.ztrzaska.rental.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.ztrzaska.rental.entity.Reservation;

import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    List<Reservation> findByRenterName(String renterName);

    List<Reservation> findByObjectForRentName(String renterName);
}
