package com.cybercom.rest.controller;

import java.net.URI;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.cybercom.model.Fruit;
import com.cybercom.services.FruitService;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;

/**
 * It is an <strong>end point API</strong> which processes all the HTTP
 * requests. It has methods to process <strong>GET</strong>,<strong>Put</strong>
 * and <strong>Post</strong> method calls.
 * 
 * @author Pedram
 * @since Jan 1 2019
 * @version 0.6.0
 */

@Slf4j
@RestController
@RequestMapping(path = "/fruitstores")
@Api(value = "onlinestores", description = "Operations opertaining to products in Online Store")
public class RestFruitController {

    /**
     * A local instance of the {@link FruitService} class
     */
    @Autowired
    private FruitService fruitsService;

    /**
     * Controller method to get {@link Fruit} object from {@link FruitService}.
     * 
     * @param id
     *            The id of the Fruits to be found
     * @return Fruits object values containing (id,fruitName , fruitType ,
     *         price)
     */

    @GetMapping(path = "/getfruits/{id}")
    public ResponseEntity<?> getFruit(@PathVariable(value = "id") Long id) {

	log.info("Finding Fruit with id: {}", id);
	Fruit fruits = fruitsService.findByFruitId(id);

	return ResponseEntity.ok(fruits);
    }

    /**
     * Controller Method to save or Update {@link Fruit} objects into DataBase.
     * 
     * @param id
     *            Fruit id which is needed to be updated or saved
     * @param newFruits
     *            Fruits values containing (fruitName , fruitType , price)
     * @return it will response which id which is updated or saved
     */
    @PostMapping(path = "/update/fruit/{id}")
    public ResponseEntity<?> updateFruit(@PathVariable Long id, @RequestBody Fruit updateFruits,
	    HttpServletRequest request) {

	log.info("update Fruit: {}", updateFruits);
	Fruit fruit = fruitsService.updateFruit(id, updateFruits);

	URI location = ServletUriComponentsBuilder.fromContextPath(request).path("/update/fruit/{id}")
		.buildAndExpand(fruit.getId()).toUri();

	return ResponseEntity.created(location).build();

    }

    /**
     * Controller Method get the list of Fruits sort by fruits Price
     * 
     * @return it will return the fruit list {@link Fruit} with http response
     *         code
     */
    @GetMapping(path = "/fruit")
    public ResponseEntity<?> fruitList() {

	return ResponseEntity.ok(fruitsService.listFruit());

    }

    /**
     * Controller Method to save {@link Fruit} objects into DataBase.
     * 
     * @param newFruits
     * @return it will response which id which is saved
     */
    @PostMapping(path = "/save/fruit")
    public ResponseEntity<?> saveFruit(@RequestBody Fruit newFruit) {
	log.info("save Fruit: {}", newFruit);
	Fruit fruit = fruitsService.saveFruit(newFruit);

	URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(fruit.getId())
		.toUri();

	return ResponseEntity.created(location).build();

    }

}