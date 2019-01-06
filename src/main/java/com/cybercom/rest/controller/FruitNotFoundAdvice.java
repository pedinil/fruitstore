package com.cybercom.rest.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

import com.cybercom.Exception.FruitNotFoundException;

/**
 * this class handle the exception if the fruit id is not found and then return
 * html page with message
 * 
 * @author pedram
 * @since Jan 4 2019
 * @version 0.1.0
 */
@ControllerAdvice
public class FruitNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(FruitNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String employeeNotFoundHandler(FruitNotFoundException ex) {
	return ex.getMessage();
    }

}
