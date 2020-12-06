/**
 * 
 */
package com.doaa.vetclinic.DAOs;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.doaa.vetclinic.entities.Doctor;
import com.doaa.vetclinic.entities.Pet;

/**
 * @author doaa1
 *
 */
@Repository
public class DoctorDAOImpl implements DoctorDAO{

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public List<Doctor> listAllDoctors() {
		Session currentSession=sessionFactory.getCurrentSession();
		
		Query<Doctor> query= currentSession.createQuery("from Doctor order by doctorName" ,Doctor.class);
		
		List<Doctor> doctorsList=query.getResultList();
		
		return doctorsList;
	}

	@Override
	public List<Doctor> listDoctorsByClinicId(int clinicId) {

		Session currentSession=sessionFactory.getCurrentSession();
		
		Query query=null;
		
		query=currentSession.createQuery("from Doctor where clinic =:id" , Pet.class);
		query.setParameter("id", clinicId);
		
		return query.getResultList();
	}

	@Override
	public void saveDoctor(Doctor doctor) {

		Session currentSession=sessionFactory.getCurrentSession();
		
		currentSession.saveOrUpdate(doctor);
	}

	@Override
	public void deleteDoctor(int id) {

		Session currentSession=sessionFactory.getCurrentSession();
		
		Query query=currentSession.createQuery("delete from Doctor where doctorId=:id");
		query.setParameter("id", id);
		query.executeUpdate();
		
	}

	@Override
	public Doctor getDoctorById(int id) {
		Session currentSession=sessionFactory.getCurrentSession();
		
		Doctor doctor=currentSession.get(Doctor.class , id);
		
		return doctor;
	}

	
}
