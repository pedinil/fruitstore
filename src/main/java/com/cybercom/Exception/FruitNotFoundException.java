package com.cybercom.Exception;

/**
 * this class is Exception class in case the Fruits is not found
 * 
 * @author pedram
 * @version 0.7.0
 * @since Jan 1 2019
 */
public class FruitNotFoundException extends RuntimeException {

    public FruitNotFoundException(Long id) {
	super("Could not find Fruits " + id);
    }

}
