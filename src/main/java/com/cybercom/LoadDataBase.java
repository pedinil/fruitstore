package com.cybercom;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.cybercom.model.Fruit;
import com.cybercom.repository.FruitRepository;
import lombok.extern.slf4j.Slf4j;

/**
 * It is will preload some data fruit in h2 database
 * 
 * @author pedram
 * @since Jan 1 2019
 * @version 0.4.0
 */
@Configuration
@Slf4j
public class LoadDataBase {

    @Bean
    CommandLineRunner initDatabase(FruitRepository repository) {
	return args -> {
	    log.info("Preloading " + repository.save(new Fruit("Banana", "green", 11d)));
	    log.info("Preloading " + repository.save(new Fruit("apple", "green", 15d)));
	    log.info("Preloading " + repository.save(new Fruit("mango", "green", 14d)));

	};
    }

}
