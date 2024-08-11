package com.example.demo.Entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "CartItems")
public class CartItems {

    @EmbeddedId
    private CartItemsId id;

    private int quantity;
    private double price;

    @ManyToOne
    @MapsId("cartId")
    @JoinColumn(name = "cart_id")
    private Cart cart;

    @ManyToOne
    @MapsId("pId")
    @JoinColumn(name = "p_id")
    private Product product;
}
