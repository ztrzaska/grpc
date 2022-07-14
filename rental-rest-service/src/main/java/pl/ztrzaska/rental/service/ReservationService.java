package pl.ztrzaska.rental.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.ztrzaska.rental.dto.ReservationDto;
import pl.ztrzaska.rental.dto.ReservationModifyDto;
import pl.ztrzaska.rental.entity.ObjectForRent;
import pl.ztrzaska.rental.entity.Renter;
import pl.ztrzaska.rental.entity.Reservation;
import pl.ztrzaska.rental.repository.ObjectForRentalRepository;
import pl.ztrzaska.rental.repository.RenterRepository;
import pl.ztrzaska.rental.repository.ReservationRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class ReservationService {

    private final ReservationValidator reservationValidator;
    private final RenterRepository renterRepository;
    private final ObjectForRentalRepository objectForRentalRepository;
    private final ReservationRepository reservationRepository;

    public synchronized Reservation create(ReservationDto reservation) {
        Optional<Renter> renter = renterRepository.findById(reservation.getRenterId());
        Optional<ObjectForRent> objectForRent = objectForRentalRepository.findById(reservation.getObjectForRentId());

        reservationValidator.validate(renter, objectForRent);
        Reservation newReservation = new Reservation(reservation.getPeriod(), reservation.getCost(), renter.get(),
                objectForRent.get());
        return reservationRepository.save(newReservation);
    }

    public void modify(ReservationModifyDto reservation) {
        Optional<Reservation> reservationToModifyOptional = reservationRepository.findById(reservation.getId());
        reservationValidator.checkReservationExists(reservationToModifyOptional);

        Reservation reservationToModify = reservationToModifyOptional.get();
        reservationToModify.setCost(reservation.getCost());
        reservationToModify.setPeriod(reservation.getPeriod());

        reservationRepository.save(reservationToModify);
    }

    @Transactional
    public List<Reservation> getReservationsByRenter(String renterName) {
        return reservationRepository.findByRenterName(renterName);
    }

    public List<Reservation> findByObjectForRentName(String renterName) {
        return reservationRepository.findByObjectForRentName(renterName);
    }

}
