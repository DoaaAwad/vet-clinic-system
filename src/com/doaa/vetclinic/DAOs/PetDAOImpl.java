/**
 * 
 */
package com.doaa.vetclinic.DAOs;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.doaa.vetclinic.entities.Pet;

/**
 * @author doaa1
 *
 */
@Repository
public class PetDAOImpl implements PetDAO{
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Pet> listAllPets() {

		Session currentSession=sessionFactory.getCurrentSession();
		
		Query<Pet> query= currentSession.createQuery("from Pet order by petName" ,Pet.class);
		
		List<Pet> petsList=query.getResultList();
		
		return petsList;
	}

	@Override
	public List<Pet> listPetsByOwnerId(BigDecimal ownerId) {
		
		Session currentSession=sessionFactory.getCurrentSession();
		
		Query query=null;
		
		if(ownerId != null) {
			query=currentSession.createQuery("from Pet where owner =:ownerId" , Pet.class);
			query.setParameter("ownerId", ownerId);
		} 
		else
			return listAllPets();
		
		return query.getResultList();
	}

	@Override
	public void savePet(Pet pet) {
		
		Session currentSession=sessionFactory.getCurrentSession();
		
		currentSession.saveOrUpdate(pet);
	}

	@Override
	public void deletePet(BigDecimal id) {
		Session currentSession=sessionFactory.getCurrentSession();
		
		Query query=currentSession.createQuery("delete from Pet where petId=:id");
		query.setParameter("id", id);
		query.executeUpdate();
	}

	@Override
	public Pet getPetById(BigDecimal id) {

		Session currentSession=sessionFactory.getCurrentSession();
		
		Pet pet=currentSession.get(Pet.class , id);
		
		return pet;
	}

}
