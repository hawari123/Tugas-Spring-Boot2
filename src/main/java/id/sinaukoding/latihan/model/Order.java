package id.sinaukoding.latihan.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "orders")
@Getter
@Setter
public class Order extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer orderId;

    @Column
    private String orderStatus;

    @Column
    private Date orderDate;

    @Column
    private Date requiredDate;

    @Column
    private Date shippedDate;




}