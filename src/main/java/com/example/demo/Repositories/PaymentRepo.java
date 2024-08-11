package com.example.demo.Repositories;

import com.example.demo.Entities.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepo  extends JpaRepository<Payment, Long> {
}