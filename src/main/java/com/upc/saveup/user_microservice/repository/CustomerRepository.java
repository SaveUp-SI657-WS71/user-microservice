package com.upc.saveup.user_microservice.repository;

import com.upc.saveup.user_microservice.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {
    Customer findByPhoneNumber(String phoneNumber);
    Customer findByEmail(String email);
    Customer findByNameAndLastNameAndPhoneNumber(String name, String lastName, String phoneNumber);

    Customer findByEmailAndPassword(String email, String password);
    boolean existsByPhoneNumber(String phoneNumber);
    boolean existsByEmail(String email);
    boolean existsByEmailAndPhoneNumber(String email, String phoneNumber);
}