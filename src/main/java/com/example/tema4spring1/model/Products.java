package com.example.tema4spring1.model;
import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.NonNull;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter

public class Products {

    @Id
    @GeneratedValue
    private Integer id;
    @NonNull
    private String name;
    private Double price;

}
