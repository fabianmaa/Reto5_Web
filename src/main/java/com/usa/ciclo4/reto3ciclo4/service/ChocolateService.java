package com.usa.ciclo4.reto3ciclo4.service;

import com.usa.ciclo4.reto3ciclo4.model.Chocolate;
import com.usa.ciclo4.reto3ciclo4.repository.ChocolateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChocolateService {
    @Autowired
    private ChocolateRepository chocolateRepository;

    public List<Chocolate> getAll(){
        return chocolateRepository.getAll();
    }

    public Optional<Chocolate> getChocolate(String reference){
        return chocolateRepository.getChocolate(reference);
    }

    public Chocolate save(Chocolate chocolate){
        if (chocolate.getReference()== null){
            return chocolate;
        }
        return chocolateRepository.save(chocolate);
    }

    public Chocolate update(Chocolate chocolate){
        if (chocolate.getReference()!= null){
            Optional<Chocolate> dbChocolate = chocolateRepository.getChocolate(chocolate.getReference());
            if (!dbChocolate.isEmpty()){
                if (chocolate.getCategory()!= null){
                    dbChocolate.get().setCategory(chocolate.getCategory());
                }
                if (chocolate.getDescription() != null){
                    dbChocolate.get().setDescription(chocolate.getDescription());
                }
                
                dbChocolate.get().setAvailability(chocolate.isAvailability());

                if (chocolate.getPrice()!= 0.0){
                    dbChocolate.get().setPrice(chocolate.getPrice());
                }
                if (chocolate.getQuantity()!= 0){
                    dbChocolate.get().setQuantity(chocolate.getQuantity());
                }
                if (chocolate.getPhotography()!= null){
                    dbChocolate.get().setPhotography(chocolate.getPhotography());
                }
                chocolateRepository.update(dbChocolate.get());
                return dbChocolate.get();
            } else {
                return chocolate;
            }
        } else {
            return chocolate;
        }
    }

    public boolean delete(String reference){
        return getChocolate(reference).map(chocolate -> {
            chocolateRepository.delete(chocolate);
            return true;
        }).orElse(false);
    }

    public List<Chocolate> getByPrice(double price){
        return chocolateRepository.getByPrice(price);
    }

    public List<Chocolate> getByDescriptionContains(String description){
        return chocolateRepository.getByDescriptionContains(description);
    }
}
