package com.upc.saveup.user_microservice.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "customer")
public class Customer extends User{
    @Column(name = "last_name", length = 20, nullable = false)
    private String lastName;

    @Column(name = "points", length = 20, nullable = false)
    private int points;

}
