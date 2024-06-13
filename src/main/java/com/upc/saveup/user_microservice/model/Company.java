package com.upc.saveup.user_microservice.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "company")
public class Company extends User{
    @Column(name = "ruc", length = 11, nullable = false)
    private String ruc;
}
