package id.sinaukoding.latihan.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "categories")
@Getter
@Setter
public class Category extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer categoryId;

    @Column
    private String categoryName;


}