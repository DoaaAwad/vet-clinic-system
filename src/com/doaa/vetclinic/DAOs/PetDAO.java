/**
 * 
 */
package com.doaa.vetclinic.DAOs;

import java.math.BigDecimal;
import java.util.List;

import com.doaa.vetclinic.entities.Owner;
import com.doaa.vetclinic.entities.Pet;

/**
 * @author doaa1
 *
 */
public interface PetDAO {

	public List<Pet> listAllPets();
	
	public List<Pet> listPetsByOwnerId(BigDecimal ownerId);

	public void savePet(Pet pet);

	public void deletePet(BigDecimal id);
	
	public Pet getPetById(BigDecimal id);
}
