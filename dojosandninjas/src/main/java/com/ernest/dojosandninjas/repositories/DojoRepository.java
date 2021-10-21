package com.ernest.dojosandninjas.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ernest.dojosandninjas.models.Dojo;

@Repository
public interface DojoRepository extends CrudRepository<Dojo, Long>{
    // this method retrieves all from the database
    List<Dojo> findAll();
    // this method finds artist with descriptions containing the search string
    List<Dojo> findByNameContaining(String name);
    // this method counts how many name contain a certain string
    Long countByNameContaining(String search);
    // this method deletes a name that starts with a specific title
    Long deleteByNameStartingWith(String search);
    
}
