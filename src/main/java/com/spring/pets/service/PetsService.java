package com.spring.pets.service;

import com.spring.pets.model.PetsDto;
import com.spring.pets.repo.Pet;
import com.spring.pets.repo.DogsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class PetsService {
    @Autowired DogsRepository repository;

    public void add(PetsDto dto) {
        repository.save(toEntity(dto));
    }

    public void delete(long id) {
        repository.deleteById(id);
    }

    public List<Pet> getDogs() {
        return (List<Pet>) repository.findAll();
    }

    public Pet getDogById(long id) {
        Optional<Pet> optionalDog = repository.findById(id);
        return optionalDog.orElseThrow(() -> new DogNotFoundException("Couldn't find a Dog with id: " + id));
    }

    private Pet toEntity(PetsDto dto) {
        Pet entity = new Pet();
        entity.setName(dto.getName());
        entity.setAge(dto.getAge());
        return entity;
    }
}