package com.ernest.dojosandninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ernest.dojosandninjas.models.Dojo;
import com.ernest.dojosandninjas.repositories.DojoRepository;
@Service
public class DojoService {
	   
    private final DojoRepository dojoRepository;
    
    public DojoService(DojoRepository dojoRepository) {
        this.dojoRepository = dojoRepository;
    }
    
    // returns all the dojos
    public Iterable<Dojo> allDojos() {
        return dojoRepository.findAll();
    }
    
    // creates a dojo
    public Dojo createDojo(Dojo b) {
        return dojoRepository.save(b);
    }
    
    // retrieves a dojo
    public Dojo findDojos(Long id) {
        Optional<Dojo> optionalDojo = dojoRepository.findById(id);
        if(optionalDojo.isPresent()) {
            return optionalDojo.get();
        } else {
            return null;
        }
    }
    
//    public List <Dojo> findByArtist(String artist) {
//    	return dojoRepository.findByArtistContaining(Example.of(artist));
//    }
    
    
    // updates a dojo
	public Dojo updateDojo(Long id, String name) {
		  Optional<Dojo> optionalDojo = dojoRepository.findById(id);
	        if(optionalDojo.isPresent()) {
	        	Dojo newDojo = optionalDojo.get();
	        	newDojo.setName(name);
	        	newDojo = dojoRepository.save(newDojo);
	            return newDojo;
	        } else {
	            return null;
	        }
}
	
	
	// delete a dojo
	public void deleteDojo(Long id) {
		// TODO Auto-generated method stub
		dojoRepository.deleteById(id);
		
	}

}
