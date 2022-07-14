package pl.ztrzaska.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.ztrzaska.grpc.*;

@Component
@RequiredArgsConstructor
public class ReservationGrpcFacade {

    private final ReservationServiceGrpc.ReservationServiceBlockingStub reservationStub;

    public ReservationCreateResponse reserve(ReservationRequest request) {
        return reservationStub.reserve(request);
    }

    public Empty modify(ReservationModifyRequest request) {
        return reservationStub.modify(request);
    }

    public ReservationListResponse findByRenter(ReservationNameRequest request) {
        return reservationStub.findByRenter(request);
    }

    public ReservationListResponse findByObjectForRentName(ReservationNameRequest request) {
        return reservationStub.findByObjectForRentName(request);
    }
}
