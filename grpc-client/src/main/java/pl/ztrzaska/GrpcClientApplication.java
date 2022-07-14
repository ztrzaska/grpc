package pl.ztrzaska;

import net.devh.boot.grpc.client.inject.GrpcClient;
import net.devh.boot.grpc.client.inject.GrpcClientBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.ztrzaska.grpc.ReservationServiceGrpc;

@SpringBootApplication
@GrpcClientBean(
		clazz =  ReservationServiceGrpc.ReservationServiceBlockingStub.class,
		beanName = "reservationStub",
		client = @GrpcClient("myReservationClient")
)
public class GrpcClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(GrpcClientApplication.class, args);
	}

}
