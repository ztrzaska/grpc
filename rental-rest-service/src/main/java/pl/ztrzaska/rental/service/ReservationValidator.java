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
            throw new UnsupportedOperationException("Osoba wynajmująca nie ustnieje");
        }

        if (!objectForRent.isPresent()) {
            throw new UnsupportedOperationException("Obiekt do wynajęcianie ustnieje");
        }
    }

    public void checkReservationExists(Optional<Reservation> reservationToModifyOptional) {
        if (!reservationToModifyOptional.isPresent()) {
            throw new UnsupportedOperationException("Reservation not exists");
        }
    }
}
