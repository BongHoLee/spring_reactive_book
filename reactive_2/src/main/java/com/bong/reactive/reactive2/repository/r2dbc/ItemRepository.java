package com.bong.reactive.reactive2.repository.r2dbc;

import com.bong.reactive.reactive2.domain.item.Item;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface ItemRepository extends ReactiveCrudRepository<Item, String> {
}
