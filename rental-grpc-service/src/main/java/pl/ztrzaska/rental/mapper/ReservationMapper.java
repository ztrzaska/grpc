package pl.ztrzaska.rental.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pl.ztrzaska.grpc.ReservationModifyRequest;
import pl.ztrzaska.grpc.ReservationRequest;
import pl.ztrzaska.grpc.ReservationResponse;
import pl.ztrzaska.rental.dto.ReservationDto;
import pl.ztrzaska.rental.dto.ReservationModifyDto;
import pl.ztrzaska.rental.entity.Reservation;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ReservationMapper {

    ReservationDto map(ReservationRequest reservation);

    ReservationModifyDto map(ReservationModifyRequest reservation);

    @Mapping(source = "list", target = "list")
    List<ReservationResponse> map(List<Reservation> list);

    @Mapping(source = "reservation.renter.id", target = "renterId")
    @Mapping(source = "reservation.objectForRent.id", target = "objectForRentId")
    ReservationResponse map(Reservation reservation);
}
