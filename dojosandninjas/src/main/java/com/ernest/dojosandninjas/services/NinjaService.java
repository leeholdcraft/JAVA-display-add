package com.ernest.dojosandninjas.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ernest.dojosandninjas.models.Ninja;
import com.ernest.dojosandninjas.repositories.NinjaRepository;

	@Service
	public class NinjaService {
	    // adding the ninja repository as a dependency
	    private final NinjaRepository ninjaRepository;
	    
	    public NinjaService(NinjaRepository ninjaRepository) {
	        this.ninjaRepository = ninjaRepository;
	    }
	    
	    // returns all the ninjas
	    public Iterable<Ninja> allNinja() {
	        return ninjaRepository.findAll();
	    }
	    
	    // creates a ninja
	    public Ninja createNinja(Ninja b) {
	        return ninjaRepository.save(b);
	    }
	    
	    // retrieves a ninja
	    public Ninja findNinja(Long id) {
	        Optional<Ninja> optionalNinja = ninjaRepository.findById(id);
	        if(optionalNinja.isPresent()) {
	            return optionalNinja.get();
	        } else {
	            return null;
	        }
	    }
	    
//	    public List <Ninja> findByArtist(String artist) {
//	    	return ninjaRepository.findByArtistContaining(artist);
//	    }
	    
	    
	    // updates a ninja
		public Ninja updateNinja(Long id, String firstName, String lastName, Integer age) {
			  Optional<Ninja> optionalNinja = ninjaRepository.findById(id);
		        if(optionalNinja.isPresent()) {
		        	Ninja newNinja = optionalNinja.get();
		        	newNinja.setFirstName(firstName);
		        	newNinja.setLastName(lastName);
		        	newNinja.setAge(age);
		        	newNinja = ninjaRepository.save(newNinja);
		            return newNinja;
		        } else {
		            return null;
		        }
	}
		
		
		// delete a ninja
		public void deleteNinja(Long id) {
			// TODO Auto-generated method stub
			ninjaRepository.deleteById(id);
			
		}

}
