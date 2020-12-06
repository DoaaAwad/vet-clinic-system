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

import com.doaa.vetclinic.entities.Owner;

/**
 * @author doaa1
 *
 */
@Repository
public class OwnerDAOImpl implements OwnerDAO{
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Owner> listAllOwners() {

		Session currentSession=sessionFactory.getCurrentSession();
		
		Query<Owner> query= currentSession.createQuery("from Owner order by ownerName" ,Owner.class);
		
		List<Owner> ownersList=query.getResultList();
		
		return ownersList;
	}

	@Override
	public void saveOwner(Owner owner) {

		Session currentSession=sessionFactory.getCurrentSession();
		
		currentSession.saveOrUpdate(owner);
		
	}

	@Override
	public void deleteOwner(BigDecimal id) {

		Session currentSession=sessionFactory.getCurrentSession();
		
		Query query=currentSession.createQuery("delete from Owner where ownerId=:id");
		query.setParameter("id", id);
		query.executeUpdate();
		
	}

	@Override
	public Owner getOwnerById(BigDecimal id) {
		//get current hibernate session
		Session currentSession=sessionFactory.getCurrentSession();
		
		//retrieve object from database using id
		Owner owner=currentSession.get(Owner.class , id);
		
		return owner;
	}

}
