package id.sinaukoding.latihan.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "stores")
@Getter
@Setter
public class Store extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer storeId;

    @Column
    private String storeName;

    @Column
    private String phone;

    @Column
    private String email;

    @Column
    private String street;

    @Column
    private String city;

    @Column
    private Integer state;

    @Column
    private String zipCode;

}