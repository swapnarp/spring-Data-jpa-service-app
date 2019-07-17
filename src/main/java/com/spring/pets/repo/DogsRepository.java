package com.spring.pets.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DogsRepository extends CrudRepository<Pet, Long> {}