### 1. **Cart Entity**

```java
package com.example.demo.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Cart")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cartId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Customer customer;

    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<CartItems> cartItems;
}
```

**Explanation:**

- **@Entity**: This annotation marks the class as a JPA entity, which means it will be mapped to a database table.
- **@Data**: Lombok's annotation to generate getters, setters, and other utility methods automatically.
- **@NoArgsConstructor and @AllArgsConstructor**: Lombok annotations to generate constructors.
- **@Table(name = "Cart")**: Specifies the table name in the database.
- **cartId**: The primary key for the `Cart` table, auto-generated.
- **customer**: A many-to-one relationship with the `Customer` entity. Each cart is associated with one customer.
- **cartItems**: A one-to-many relationship with `CartItems`. The `cascade = CascadeType.ALL` ensures that any operations on `Cart` will cascade to `CartItems`, and `orphanRemoval = true` ensures that if a `CartItems` is removed from `Cart`, it will be deleted from the database.

### 2. **CartItems Entity**

```java
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
```

**Explanation:**

- **CartItemsId**: The composite key class, represented by the `@EmbeddedId` annotation.
- **quantity and price**: Fields to store the quantity and price of the product in the cart.
- **cart**: A many-to-one relationship with `Cart`. The `MapsId("cartId")` indicates that this entity is part of the composite key.
- **product**: A many-to-one relationship with `Product`, also part of the composite key.

### 3. **CartItemsId Class**

```java
package com.example.demo.Entities;

import java.io.Serializable;
import java.util.Objects;

public class CartItemsId implements Serializable {

    private Long cartId;
    private Long pId;

    public CartItemsId() {}

    public CartItemsId(Long cartId, Long pId) {
        this.cartId = cartId;
        this.pId = pId;
    }

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
```

**Explanation:**

- **Serializable**: Required for composite keys to allow serialization of the object.
- **cartId and pId**: The fields that make up the composite key.
- **equals() and hashCode()**: Essential methods to compare and hash the composite key.

### 4. **Category Entity**

```java
package com.example.demo.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Setter
@Getter
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cId;

    private String name;
    private String picture;
    private String description;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Product> products;
}
```

**Explanation:**

- **cId**: Primary key for the `Category` table.
- **name, picture, description**: Fields to store information about the category.
- **products**: One-to-many relationship with `Product`. Each category can have multiple products.

### 5. **Customer Entity**

```java
package com.example.demo.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String name;
    private String email;
    private String password;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Cart> carts;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Orders> orders;
}
```

**Explanation:**

- **userId**: Primary key for the `Customer` table.
- **name, email, password**: Fields to store customer information.
- **carts and orders**: One-to-many relationships with `Cart` and `Orders`, respectively. A customer can have multiple carts and orders.

### 6. **Orders Entity**

```java
package com.example.demo.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Orders")
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;

    private double orderAmount;
    private java.time.LocalDateTime orderDate;

    @OneToMany(mappedBy = "orders", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Payment> payments;
}
```

**Explanation:**

- **orderId**: Primary key for the `Orders` table.
- **customer**: Many-to-one relationship with `Customer`.
- **cart**: Many-to-one relationship with `Cart`.
- **orderAmount and orderDate**: Fields to store the amount and date of the order.
- **payments**: One-to-many relationship with `Payment`. Each order can have multiple payments.

### 7. **Payment Entity**

```java
package com.example.demo.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Payment")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long paymentId;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Orders orders;

    private String type;
    private double amount;
}
```

**Explanation:**

- **paymentId**: Primary key for the `Payment` table.
- **orders**: Many-to-one relationship with `Orders`.
- **type and amount**: Fields to store payment type and amount.

### 8. **Product Entity**

```java
package com.example.demo.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pId;

    private String name;
    private double price;
    private String description;

    @ManyToOne
    @JoinColumn(name = "c_id")
    private Category category;
}
```

**Explanation:**

- **pId**: Primary key for the `Product` table.
- **name, price, description**: Fields to store product information.
- **category**: Many-to-one relationship with `Category`. Each product belongs to one category.
