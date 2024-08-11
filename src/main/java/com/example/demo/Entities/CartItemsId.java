package com.example.demo.Entities;

import java.io.Serializable;
import java.util.Objects;

public class CartItemsId implements Serializable {

    private Long cartId;
    private Long pId;

    // Default constructor
    public CartItemsId() {}

    public CartItemsId(Long cartId, Long pId) {
        this.cartId = cartId;
        this.pId = pId;
    }

    // Getters, Setters, hashCode, equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CartItemsId that = (CartItemsId) o;
        return Objects.equals(cartId, that.cartId) &&
                Objects.equals(pId, that.pId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cartId, pId);
    }
}