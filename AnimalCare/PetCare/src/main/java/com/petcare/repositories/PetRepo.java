package com.petcare.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.petcare.entities.Pet;

public interface PetRepo  extends JpaRepository<Pet, Integer>{

}
