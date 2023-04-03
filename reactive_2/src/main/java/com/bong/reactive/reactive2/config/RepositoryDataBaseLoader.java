package com.bong.reactive.reactive2.config;

import com.bong.reactive.reactive2.repository.jpa.BlockingItemRepository;
import com.bong.reactive.reactive2.domain.item.Item;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RepositoryDataBaseLoader {

    @Bean
    CommandLineRunner initializer(BlockingItemRepository itemRepository) {
        return args ->  {
            itemRepository.save(new Item("Alf alarm clock", 19.99));
            itemRepository.save(new Item("Smurf TV Tray",24.99));
        };
    }
}
