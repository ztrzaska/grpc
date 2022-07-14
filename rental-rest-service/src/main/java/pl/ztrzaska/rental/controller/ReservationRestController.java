package pl.ztrzaska.rental.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pl.ztrzaska.rental.dto.ReservationDto;
import pl.ztrzaska.rental.dto.ReservationModifyDto;
import pl.ztrzaska.rental.entity.Reservation;
import pl.ztrzaska.rental.service.ReservationService;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/reservations")
public class ReservationRestController {

    private final ReservationService reservationService;

    @PostMapping(path = "/create")
    public Long create(@Validated @RequestBody ReservationDto reservation) {
        Reservation newReservation = reservationService.create(reservation);
        return newReservation.getId();
    }

    @PutMapping("/modify")
    public void modify(@Validated @RequestBody ReservationModifyDto reservation) {
        reservationService.modify(reservation);
    }

    @GetMapping("/find-by-renter")
    public List<Reservation> getReservationsByRenter(@RequestParam(name = "name") String name) {
        return reservationService.getReservationsByRenter(name);
    }

    @GetMapping("/find-by-object-for-rent")
    public List<Reservation> findByObjectForRentName(@RequestParam(name = "name") String name) {
        return reservationService.findByObjectForRentName(name);
    }

}
