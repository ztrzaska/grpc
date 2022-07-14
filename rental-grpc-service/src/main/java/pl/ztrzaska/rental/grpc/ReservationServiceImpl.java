package pl.ztrzaska.rental.grpc;

import io.grpc.stub.StreamObserver;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.stereotype.Component;
import pl.ztrzaska.grpc.*;
import pl.ztrzaska.rental.mapper.ReservationMapper;
import pl.ztrzaska.rental.dto.ReservationDto;
import pl.ztrzaska.rental.dto.ReservationModifyDto;
import pl.ztrzaska.rental.entity.Reservation;
import pl.ztrzaska.rental.service.ReservationService;

import java.util.List;

@GrpcService
@Slf4j
@RequiredArgsConstructor
@Component
public class ReservationServiceImpl extends ReservationServiceGrpc.ReservationServiceImplBase {

    private final ReservationService reservationService;
    private final ReservationMapper reservationMapper;

    @Override
    public void reserve(ReservationRequest request, StreamObserver<ReservationCreateResponse> responseObserver) {
        log.info("Received period: {}, cost: {}", request.getPeriod(), request.getCost());
        ReservationDto reservationDto = reservationMapper.map(request);
        Reservation reservation = reservationService.create(reservationDto);

        responseObserver.onNext(ReservationCreateResponse.newBuilder().setId(reservation.getId()).build());
        responseObserver.onCompleted();
    }

    @Override
    public void modify(ReservationModifyRequest request, StreamObserver<Empty> responseObserver) {
        log.info("Received id: {}, period: {}, cost: {}", request.getId(), request.getPeriod(), request.getCost());
        ReservationModifyDto reservationModifyDto = reservationMapper.map(request);
        reservationService.modify(reservationModifyDto);
        responseObserver.onNext(Empty.newBuilder().build());
        responseObserver.onCompleted();
    }

    @Override
    public void findByRenter(ReservationNameRequest request, StreamObserver<ReservationListResponse> responseObserver) {
        log.info("findByRenter name: {}", request.getName());
        List<Reservation> reservationsByRenter = reservationService.findByRenter(request.getName());
        List<ReservationResponse> reservationsResponse = reservationMapper.map(reservationsByRenter);

        responseObserver.onNext(ReservationListResponse.newBuilder().addAllList(reservationsResponse).build());
        responseObserver.onCompleted();
    }

    @Override
    public void findByObjectForRentName(ReservationNameRequest request,
                                    StreamObserver<ReservationListResponse> responseObserver) {
        log.info("findByObjectForRent name: {}", request.getName());
        List<Reservation> byObjectForRentName = reservationService.findByObjectForRentName(request.getName());
        List<ReservationResponse> reservationsResponse = reservationMapper.map(byObjectForRentName);

        responseObserver.onNext(ReservationListResponse.newBuilder().addAllList(reservationsResponse).build());
        responseObserver.onCompleted();
    }
}
