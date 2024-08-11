package com.example.demo.Controllers;


import com.example.demo.Entities.CartItems;
import com.example.demo.Entities.CartItemsId;
import com.example.demo.Services.CartItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cart-items")
public class CartItemsController {

    @Autowired
    private CartItemsService cartItemsService;

    @GetMapping
    public List<CartItems> getAllCartItems() {
        return cartItemsService.getAllCartItems();
    }

    @GetMapping("/{cartId}/{pId}")
    public ResponseEntity<CartItems> getCartItemsById(@PathVariable Long cartId, @PathVariable Long pId) {
        CartItemsId id = new CartItemsId(cartId, pId);
        CartItems cartItems = cartItemsService.getCartItemsById(id);
        if (cartItems != null) {
            return ResponseEntity.ok(cartItems);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public CartItems createCartItems(@RequestBody CartItems cartItems) {
        return cartItemsService.saveCartItems(cartItems);
    }

    @PutMapping("/{cartId}/{pId}")
    public ResponseEntity<CartItems> updateCartItems(@PathVariable Long cartId, @PathVariable Long pId, @RequestBody CartItems cartItems) {
        CartItemsId id = new CartItemsId(cartId, pId);
        CartItems existingCartItems = cartItemsService.getCartItemsById(id);
        if (existingCartItems != null) {
            cartItems.setId(id);
            return ResponseEntity.ok(cartItemsService.saveCartItems(cartItems));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{cartId}/{pId}")
    public ResponseEntity<Void> deleteCartItems(@PathVariable Long cartId, @PathVariable Long pId) {
        CartItemsId id = new CartItemsId(cartId, pId);
        CartItems cartItems = cartItemsService.getCartItemsById(id);
        if (cartItems != null) {
            cartItemsService.deleteCartItems(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}