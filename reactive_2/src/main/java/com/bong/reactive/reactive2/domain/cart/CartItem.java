package com.bong.reactive.reactive2.domain.cart;


import com.bong.reactive.reactive2.domain.item.Item;
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
