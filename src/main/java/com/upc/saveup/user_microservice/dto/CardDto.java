package com.upc.saveup.user_microservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CardDto {
    private int id;
    private String cardName;
    private String cardNumber;
    private String type;
    private int customerId;
}
