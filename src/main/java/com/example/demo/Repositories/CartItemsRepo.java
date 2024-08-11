package com.example.demo.Repositories;

import com.example.demo.Entities.CartItems;
import com.example.demo.Entities.CartItemsId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemsRepo extends JpaRepository<CartItems, CartItemsId> {
}
