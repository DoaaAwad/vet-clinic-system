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

import com.doaa.vetclinic.entities.Visit;

/**
 * @author doaa1
 *
 */
@Repository
public class VisitDAOImpl implements VisitDAO {
	
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public List<Visit> listAllVisits() {

		Session currentSession=sessionFactory.getCurrentSession();
		
		Query<Visit> query= currentSession.createQuery("from Visit order by visitDate" ,Visit.class);
		
		List<Visit> visitsList=query.getResultList();
		
		return visitsList;
	}

	@Override
	public void saveVisit(Visit visit) {
		
		Session currentSession=sessionFactory.getCurrentSession();
		
		currentSession.saveOrUpdate(visit);		
	}

	@Override
	public void deleteVisit(BigDecimal id) {
		
		Session currentSession=sessionFactory.getCurrentSession();
		
		Query query=currentSession.createQuery("delete from Visit where visitId=:id");
		query.setParameter("id", id);
		query.executeUpdate();
	
		
	}

	@Override
	public Visit getVisitById(BigDecimal id) {
		
		Session currentSession=sessionFactory.getCurrentSession();
		
		Visit visit=currentSession.get(Visit.class , id);
		
		return visit;
	}

}
