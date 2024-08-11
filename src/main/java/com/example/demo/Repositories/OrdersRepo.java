package com.example.demo.Repositories;

import com.example.demo.Entities.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersRepo  extends JpaRepository<Orders, Long> {
}
