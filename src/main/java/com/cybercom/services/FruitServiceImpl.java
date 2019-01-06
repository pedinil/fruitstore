package com.cybercom.services;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cybercom.Exception.FruitNotFoundException;
import com.cybercom.model.Fruit;
import com.cybercom.repository.FruitRepository;

@Service
public class FruitServiceImpl implements FruitService {

    @Autowired
    private FruitRepository fruitsRepository;

    @Override
    public Fruit findByFruitId(Long id) {
	return fruitsRepository.findById(id).orElseThrow(() -> new FruitNotFoundException(id));
    }

    @Override
    public Fruit updateFruit(Long id, Fruit newFruits) {
	return fruitsRepository.findById(id).map(fruit -> {
	    fruit.setFruitName(newFruits.getFruitName());
	    fruit.setFruitType(newFruits.getFruitType());
	    fruit.setPrice(newFruits.getPrice());
	    return fruitsRepository.save(fruit);
	}).orElseGet(() -> {
	    return fruitsRepository.save(newFruits);
	});

    }

    @Override
    public List<Fruit> listFruit() {
	return fruitsRepository.findAll().stream().sorted(Comparator.comparing(Fruit::getPrice))
		.collect(Collectors.toList());

    }

    @Override
    public Fruit saveFruit(Fruit fruit) {
	return fruitsRepository.save(fruit);
    }

}
