package com.cybercom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cybercom.model.Fruit;

/**
 * FruitRepository allows all operations to Fruit Entity like ( save , findall ,
 * findbyid , etc)
 * 
 * @author pedram
 * @version 1.0.0
 * @since Dec 25 2018
 */

public interface FruitRepository extends JpaRepository<Fruit, Long> {

}
