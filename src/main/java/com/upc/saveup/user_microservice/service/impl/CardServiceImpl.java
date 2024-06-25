package com.upc.saveup.user_microservice.service.impl;

import com.upc.saveup.user_microservice.dto.CardDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class CardServiceImpl {
    private final RestTemplate restTemplate;

    @Autowired
    public CardServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<CardDto> getCardsByCustomerId(int customerId) {
        String url = "http://192.168.56.1:8084/api/saveup/v1/cards/customer/" + customerId;
        ResponseEntity<List<CardDto>> response = restTemplate.exchange(url, HttpMethod.GET, null,
                new ParameterizedTypeReference<List<CardDto>>() {});
        return response.getBody();
    }
}
