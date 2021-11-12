package com.schoolofnet.Testing.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.schoolofnet.Testing.models.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long>{

}
