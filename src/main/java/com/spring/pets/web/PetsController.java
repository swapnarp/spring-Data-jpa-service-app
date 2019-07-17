package com.spring.pets.web;

import com.spring.pets.model.PetsDto;
import com.spring.pets.repo.Pet;
import com.spring.pets.service.PetsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/dogs")
public class PetsController {
    @Autowired
    PetsService service;

    @GetMapping
    public List<Pet> getDogs() {
        return service.getDogs();
    }

    @PostMapping
    public void postDogs(@RequestBody PetsDto dto) {
        service.add(dto);
    }

    @GetMapping("/{id}")
    public Pet getById(@PathVariable(required = true) long id) {
        return service.getDogById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(required = true) long id) {
        service.delete(id);
    }
}