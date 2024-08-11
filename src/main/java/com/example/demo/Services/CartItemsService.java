package com.example.demo.Services;

import com.example.demo.Entities.CartItems;
import com.example.demo.Entities.CartItemsId;
import com.example.demo.Repositories.CartItemsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CartItemsService {
    @Autowired
    private CartItemsRepo cartItemsRepository;

    public List<CartItems> getAllCartItems() {
        return cartItemsRepository.findAll();
    }

    public CartItems getCartItemsById(CartItemsId id) {
        return cartItemsRepository.findById(id).orElse(null);
    }

    public CartItems saveCartItems(CartItems cartItems) {
        return cartItemsRepository.save(cartItems);
    }

    public void deleteCartItems(CartItemsId id) {
        cartItemsRepository.deleteById(id);
    }
}
