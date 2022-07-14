package pl.ztrzaska.rental.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * Obiekt do wynajęcia
 */
@Entity
@Table(name = "OBJECT_FOR_RENT")
@Getter @Setter
public class ObjectForRent {

    @Id
    @Column
    private Long id;

    @Column
    private String name;

    @Column
    private BigDecimal price;

    @Column
    private String area;

    @Column
    private String description;
}
