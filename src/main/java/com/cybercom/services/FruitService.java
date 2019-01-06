package com.cybercom.services;

import java.util.List;

import com.cybercom.model.Fruit;

/**
 * The service class for {@link Fruit}
 * 
 * @author Pedram
 * @version 1.0.0
 * @since Dec 25 2018
 *
 */
public interface FruitService {

    /**
     * Finds {@link Fruit} by its id
     * 
     * @param id
     *            ID of the fruit {@link Fruit} to be found
     * @return The found fruit {@link Fruit}
     */
    Fruit findByFruitId(Long id);

    /**
     * 
     * @param id
     *            ID of the fruit to be found
     * @param fruit
     *            fruit {@link Fruit} object to update
     * @return the updated fruit {@link Fruit} object or saved
     */
    Fruit updateFruit(Long id, Fruit fruit);

    /**
     * 
     * @return all the list of fruit {@link Fruit}
     */
    List<Fruit> listFruit();

    /**
     * 
     * @param fruit
     *            fruit object to be saved
     * @return fruit {@link Fruit} object which is saved
     */
    Fruit saveFruit(Fruit fruit);

}
