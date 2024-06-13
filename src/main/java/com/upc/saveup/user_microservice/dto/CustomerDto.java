package com.upc.saveup.user_microservice.dto;

import com.upc.saveup.user_microservice.model.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDto {
    private int id;
    private String name;
    private String email;
    private String lastName;
    private int points;
    private List<CardDto> cards;

    public CustomerDto(Customer customer, List<CardDto> cards) {
        this.id = customer.getId();
        this.name = customer.getName();
        this.email = customer.getEmail();
        this.lastName = customer.getLastName();
        this.points = customer.getPoints();
        this.cards = cards;
    }
}
