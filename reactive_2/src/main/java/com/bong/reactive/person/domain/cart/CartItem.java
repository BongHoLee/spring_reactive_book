package com.bong.reactive.person.domain.cart;


import com.bong.reactive.person.domain.item.Item;
import lombok.Getter;

@Getter
public class CartItem {
    private Item item;
    private int quantity;

    CartItem(Item item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }

}
