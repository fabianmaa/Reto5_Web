package com.usa.ciclo4.reto3ciclo4.controller;

import com.usa.ciclo4.reto3ciclo4.model.Chocolate;
import com.usa.ciclo4.reto3ciclo4.service.ChocolateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/chocolate")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class ChocolateController {
    @Autowired
    private ChocolateService chocolateService;

    @GetMapping("/all")
    public List<Chocolate> getAll(){
        return chocolateService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Chocolate> getChocolate(@PathVariable("reference") String reference){
        return chocolateService.getChocolate(reference);
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody Chocolate chocolate){
        chocolateService.save(chocolate);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Chocolate update(@RequestBody Chocolate chocolate){
        return chocolateService.update(chocolate);
    }

    @DeleteMapping("/{reference}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("reference") String reference){
        return chocolateService.delete(reference);
    }

    @GetMapping("/price/{price}")
    public List<Chocolate> getByPrice(@PathVariable("price") double price){
        return chocolateService.getByPrice(price);
    }

    @GetMapping("/description/{description}")
    public List<Chocolate> getByDescriptionContains(@PathVariable("description") String description){
        return chocolateService.getByDescriptionContains(description);
    }
}
