package pl.ztrzaska.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.ztrzaska.dto.ReservationCreateDto;
import pl.ztrzaska.dto.ReservationDto;
import pl.ztrzaska.dto.ReservationModifyDto;
import pl.ztrzaska.grpc.*;
import pl.ztrzaska.mapper.ReservationMapper;
import pl.ztrzaska.service.ReservationGrpcFacade;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reservations")
public class GrpcCallRestController {

    private final ReservationGrpcFacade reservationGrpcFacade;
    private final ReservationMapper reservationMapper;

    @PostMapping(path = "/create")
    public Long create(@RequestBody ReservationCreateDto reservation) {
        ReservationRequest request = reservationMapper.map(reservation);
        ReservationCreateResponse reservationResponse = reservationGrpcFacade.reserve(request);
        return reservationResponse.getId();
    }

    @PutMapping("/modify")
    public void modify(@RequestBody ReservationModifyDto reservation) {
        ReservationModifyRequest request = reservationMapper.map(reservation);
        reservationGrpcFacade.modify(request);
    }

    @GetMapping("/find-by-renter")
    public List<ReservationDto> findByRenter(@RequestParam(name = "name") String name) {
        ReservationNameRequest request = ReservationNameRequest.newBuilder().setName(name).build();
        ReservationListResponse response = reservationGrpcFacade.findByRenter(request);
        return reservationMapper.map(response);
    }

    @GetMapping("/find-by-object-for-rent")
    public List<ReservationDto> findByObjectForRentName(@RequestParam(name = "name") String name) {
        ReservationNameRequest request = ReservationNameRequest.newBuilder().setName(name).build();
        ReservationListResponse response = reservationGrpcFacade.findByObjectForRentName(request);
        return reservationMapper.map(response);
    }
}
