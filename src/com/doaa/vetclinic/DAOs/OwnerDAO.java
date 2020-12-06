/**
 * 
 */
package com.doaa.vetclinic.DAOs;

import java.util.List;

import com.doaa.vetclinic.entities.Owner;

/**
 * @author doaa1
 *
 */
public interface OwnerDAO {
	
	public List<Owner> listAllOwners();

	public void saveOwner(Owner owner);

	public void deleteOwner(int id);
	
	public Owner getOwnerById(int id);
	
}
