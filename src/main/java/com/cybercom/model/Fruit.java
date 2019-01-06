package com.cybercom.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Fruits class hold information related to a Fruits table
 * 
 * @author Pedram
 * @since Jan 1 2019
 * @version 0.4.0
 */

@Data
@Entity
@NoArgsConstructor
public class Fruit {

    @Id
    @GeneratedValue
    private Long id;

    private String fruitType;

    private String fruitName;

    private Double price;

    public Fruit(String fruitName, String fruitType, Double price) {
	this.fruitType = fruitType;
	this.fruitName = fruitName;
	this.price = price;
    }

}
