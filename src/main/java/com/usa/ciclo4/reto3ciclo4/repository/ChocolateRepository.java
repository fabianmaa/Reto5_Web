package com.usa.ciclo4.reto3ciclo4.repository;

import com.usa.ciclo4.reto3ciclo4.model.Chocolate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import com.usa.ciclo4.reto3ciclo4.repository.crud.ChocolateCrudRepository;

@Repository
public class ChocolateRepository {
    @Autowired
    private ChocolateCrudRepository chocolateCrudRepository;

    public List<Chocolate> getAll(){
        return chocolateCrudRepository.findAll();
    }

    public Optional<Chocolate> getChocolate(String reference){
        return chocolateCrudRepository.findByReference(reference);
    }

    public Chocolate save(Chocolate chocolate){
        return chocolateCrudRepository.save(chocolate);
    }

    public void update(Chocolate chocolate){
        chocolateCrudRepository.save(chocolate);
    }

    public void delete(Chocolate chocolate){
        chocolateCrudRepository.delete(chocolate);
    }

    public List<Chocolate> getByPrice(double price){
        return chocolateCrudRepository.findByPrice(price);
    }

    public List<Chocolate> getByDescriptionContains(String description){
        return chocolateCrudRepository.findByDescriptionContainingIgnoreCase(description);
    }
}
