/**
 * 
 */
package com.doaa.vetclinic.DAOs;

import java.util.List;

import com.doaa.vetclinic.entities.Pet;

/**
 * @author doaa1
 *
 */
public interface PetDAO {

	public List<Pet> listAllPets();
	
	public List<Pet> listPetsByOwnerId(int ownerId);

	public void savePet(Pet pet);

	public void deletePet(int id);
	
	public Pet getPetById(int id);
}
