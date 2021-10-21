package com.ernest.dojosandninjas.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ernest.dojosandninjas.models.Ninja;

@Repository
public interface NinjaRepository extends CrudRepository<Ninja, Long>{
    // this method retrieves all from the database
    List<Ninja> findAll();
    // this method finds artist with descriptions containing the search string
    List<Ninja> findByFirstNameContaining(String firstName);
    // this method counts how many name contain a certain string
    Long countByFirstNameContaining(String search);
    // this method deletes a name that starts with a specific title
    Long deleteByFirstNameStartingWith(String search);
    
}