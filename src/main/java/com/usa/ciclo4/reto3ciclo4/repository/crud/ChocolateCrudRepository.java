package com.usa.ciclo4.reto3ciclo4.repository.crud;

import com.usa.ciclo4.reto3ciclo4.model.Chocolate;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface ChocolateCrudRepository extends MongoRepository<Chocolate, Integer> {
    public List<Chocolate> findByPrice(double price);
    public List<Chocolate> findByDescriptionContainingIgnoreCase(String description);

    public Optional<Chocolate> findByReference(String reference);
}
