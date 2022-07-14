package pl.ztrzaska.rental.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Wynajmujący
 */
@Entity
@Table(name = "RENTER")
@Getter @Setter
public class Renter {

    @Id
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME")
    private String name;
}
