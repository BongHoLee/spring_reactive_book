package com.bong.reactive.reactive2.repository.jpa;

import com.bong.reactive.reactive2.domain.item.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlockingItemRepository extends JpaRepository<Item, String> { }
