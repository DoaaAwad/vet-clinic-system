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

import com.doaa.vetclinic.entities.Clinic;

/**
 * @author doaa1
 *
 */
@Repository
public class ClinicDAOImpl implements ClinicDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Clinic> listAllClinics() {
		
		Session currentSession=sessionFactory.getCurrentSession();
		
		Query<Clinic> query= currentSession.createQuery("from Clinic order by clinicName" ,Clinic.class);
		
		List<Clinic> clinicsList=query.getResultList();
		
		return clinicsList;
	}

	@Override
	public List<Clinic> searchClinicByPhone(BigDecimal phoneNum) {
		
		Session currentSession=sessionFactory.getCurrentSession();
		
		Query query=null;
		if(phoneNum != null) {
			query=currentSession.createQuery("from Clinic where phone =:phoneNum" , Clinic.class);
			query.setParameter("phoneNum", phoneNum);
		} else {
			return listAllClinics();
		}
		List<Clinic> clinicsList = query.getResultList();
		return clinicsList;
	}

	@Override
	public List<Clinic> searchClinicByAddress(String address) {

		Session currentSession=sessionFactory.getCurrentSession();
		
		Query query=null;
		
		if(address!=null && address.trim().length() > 0) {
			query=currentSession.createQuery("from Clinic where lower(address) like :key" , Clinic.class);
			query.setParameter("key",  "%" + address.toLowerCase() + "%");
		}
		
		else
			return listAllClinics();
		
		return query.getResultList();
	}

	@Override
	public void saveClinic(Clinic clinic) {

		Session currentSession=sessionFactory.getCurrentSession();
		
		currentSession.saveOrUpdate(clinic);		
	}

	@Override
	public void deleteClinic(BigDecimal id) {

		Session currentSession=sessionFactory.getCurrentSession();
		
		Query query=currentSession.createQuery("delete from Clinic where clinicId=:id");
		query.setParameter("id", id);
		query.executeUpdate();
		
	}

	@Override
	public Clinic getClinicById(BigDecimal id) {

		Session currentSession=sessionFactory.getCurrentSession();
		
		Clinic clinic=currentSession.get(Clinic.class , id);
		
		return clinic;
	}

}
