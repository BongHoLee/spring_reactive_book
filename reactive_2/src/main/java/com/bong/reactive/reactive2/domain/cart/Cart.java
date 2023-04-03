package com.bong.reactive.reactive2.domain.cart;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("carts")
@Getter
public class Cart {

    @Id
    private String id;
    private List<CartItem> cartItems;

    public Cart(String id, List<CartItem> cartItems) {
        this.id = id;
        this.cartItems = cartItems;
    }

    public Cart(String id) {
        this(id, new ArrayList<>());
    }


}
