package pl.ztrzaska.mapper;

import org.mapstruct.Mapper;
import pl.ztrzaska.dto.ReservationCreateDto;
import pl.ztrzaska.dto.ReservationDto;
import pl.ztrzaska.dto.ReservationModifyDto;
import pl.ztrzaska.grpc.ReservationListResponse;
import pl.ztrzaska.grpc.ReservationModifyRequest;
import pl.ztrzaska.grpc.ReservationRequest;
import pl.ztrzaska.grpc.ReservationResponse;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring")
public interface ReservationMapper {

    ReservationRequest map(ReservationCreateDto reservation);

    ReservationModifyRequest  map(ReservationModifyDto reservation);

    ReservationDto map(ReservationResponse reservation);

    default List<ReservationDto> map(ReservationListResponse sourceObject) {
        List<ReservationDto> result = new ArrayList<>();
        for(ReservationResponse res : sourceObject.getListList()){
            result.add(map(res));
        }
        return result;
    }
}
