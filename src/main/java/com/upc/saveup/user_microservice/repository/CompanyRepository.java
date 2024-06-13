package com.upc.saveup.user_microservice.repository;

import com.upc.saveup.user_microservice.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer> {
    Company findByPhoneNumber(String phoneNumber);
    Company findByEmail(String email);
    Company findByEmailAndPassword(String email, String password);
    boolean existsByPhoneNumber(String phoneNumber);
    boolean existsByEmail(String email);
    boolean existsByEmailAndPhoneNumber(String email, String phoneNumber);
}