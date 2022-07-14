package pl.ztrzaska.dto;


import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter @Setter
public class ReservationDto implements Serializable {

    private Long id;
    private String period;
    private BigDecimal cost;
    private Long renterId;
    private Long objectForRentId;

}
