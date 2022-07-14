package pl.ztrzaska.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter @Setter
public class ReservationModifyDto implements Serializable {

    private Long id;
    private String period;
    private BigDecimal cost;
}
