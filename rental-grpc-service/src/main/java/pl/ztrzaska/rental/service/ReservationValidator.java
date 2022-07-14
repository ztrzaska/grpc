package pl.ztrzaska.rental.service;

import org.springframework.stereotype.Component;
import pl.ztrzaska.rental.entity.ObjectForRent;
import pl.ztrzaska.rental.entity.Renter;
import pl.ztrzaska.rental.entity.Reservation;

import java.util.Optional;

@Component
public final class ReservationValidator {

    public void validate(Optional<Renter> renter, Optional<ObjectForRent> objectForRent) {
        if (!renter.isPresent()) {
            throw new UnsupportedOperationException("Renter not exists");
        }

        if (!objectForRent.isPresent()) {
            throw new UnsupportedOperationException("Object for rent not exists");
        }
    }

    public void checkReservationExists(Optional<Reservation> reservationToModifyOptional) {
        if (!reservationToModifyOptional.isPresent()) {
            throw new UnsupportedOperationException("Reservation not exists");
        }
    }
}
