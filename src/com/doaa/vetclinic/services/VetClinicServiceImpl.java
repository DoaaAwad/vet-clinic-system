/**
 * 
 */
package com.doaa.vetclinic.services;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.doaa.vetclinic.DAOs.ClinicDAO;
import com.doaa.vetclinic.DAOs.DoctorDAO;
import com.doaa.vetclinic.DAOs.OwnerDAO;
import com.doaa.vetclinic.DAOs.PetDAO;
import com.doaa.vetclinic.DAOs.VisitDAO;
import com.doaa.vetclinic.entities.Clinic;
import com.doaa.vetclinic.entities.Doctor;
import com.doaa.vetclinic.entities.Owner;
import com.doaa.vetclinic.entities.Pet;
import com.doaa.vetclinic.entities.Visit;

/**
 * @author doaa1
 *
 */
@Service
@Transactional
public class VetClinicServiceImpl implements VetClinicService{
	
	@Autowired
	private ClinicDAO clinicDAO;
	
	@Autowired
	private DoctorDAO doctorDAO;
	
	@Autowired
	private OwnerDAO ownerDAO;
	
	@Autowired
	private PetDAO petDAO;
	
	@Autowired
	private VisitDAO visitDAO;

	@Override
	public List<Owner> listAllOwners() {
		// TODO Auto-generated method stub
		return ownerDAO.listAllOwners();
	}

	@Override
	public void saveOwner(Owner owner) {
		// TODO Auto-generated method stub
		ownerDAO.saveOwner(owner);
	}

	@Override
	public void deleteOwner(BigDecimal id) {
		// TODO Auto-generated method stub
		ownerDAO.deleteOwner(id);
	}

	@Override
	public Owner getOwnerById(BigDecimal id) {
		// TODO Auto-generated method stub
		return ownerDAO.getOwnerById(id);
	}

	@Override
	public List<Pet> listAllPets() {
		// TODO Auto-generated method stub
		return petDAO.listAllPets();
	}

	@Override
	public List<Pet> listPetsByOwnerId(BigDecimal ownerId) {
		// TODO Auto-generated method stub
		return petDAO.listPetsByOwnerId(ownerId);
	}

	@Override
	public void savePet(Pet pet) {
		// TODO Auto-generated method stub
		petDAO.savePet(pet);
	}

	@Override
	public void deletePet(BigDecimal id) {
		// TODO Auto-generated method stub
		petDAO.deletePet(id);
	}

	@Override
	public Pet getPetById(BigDecimal id) {
		// TODO Auto-generated method stub
		return petDAO.getPetById(id);
	}

	@Override
	public List<Clinic> listAllClinics() {
		// TODO Auto-generated method stub
		return clinicDAO.listAllClinics();
	}

	@Override
	public List<Clinic> searchClinicByPhone(BigDecimal phoneNum) {
		// TODO Auto-generated method stub
		return clinicDAO.searchClinicByPhone(phoneNum);
	}

	@Override
	public List<Clinic> searchClinicByAddress(String address) {
		// TODO Auto-generated method stub
		return clinicDAO.searchClinicByAddress(address);
	}

	@Override
	public void saveClinic(Clinic clinic) {
		// TODO Auto-generated method stub
		clinicDAO.saveClinic(clinic);
	}

	@Override
	public void deleteClinic(BigDecimal id) {
		// TODO Auto-generated method stub
		clinicDAO.deleteClinic(id);
	}

	@Override
	public Clinic getClinicById(BigDecimal id) {
		// TODO Auto-generated method stub
		return clinicDAO.getClinicById(id);
	}

	@Override
	public List<Doctor> listAllDoctors() {
		// TODO Auto-generated method stub
		return doctorDAO.listAllDoctors();
	}

	@Override
	public List<Doctor> listDoctorsByClinicId(BigDecimal clinicId) {
		// TODO Auto-generated method stub
		return doctorDAO.listDoctorsByClinicId(clinicId);
	}

	@Override
	public void saveDoctor(Doctor doctor) {
		// TODO Auto-generated method stub
		doctorDAO.saveDoctor(doctor);
	}

	@Override
	public void deleteDoctor(BigDecimal id) {
		// TODO Auto-generated method stub
		doctorDAO.deleteDoctor(id);
	}

	@Override
	public Doctor getDoctorById(BigDecimal id) {
		// TODO Auto-generated method stub
		return doctorDAO.getDoctorById(id);
	}

	@Override
	public List<Visit> listAllVisits() {
		// TODO Auto-generated method stub
		return visitDAO.listAllVisits();
	}

	@Override
	public void saveVisit(Visit visit) {
		// TODO Auto-generated method stub
		visitDAO.saveVisit(visit);
	}

	@Override
	public void deleteVisit(BigDecimal id) {
		// TODO Auto-generated method stub
		visitDAO.deleteVisit(id);
	}

	@Override
	public Visit getVisitById(BigDecimal id) {
		// TODO Auto-generated method stub
		return visitDAO.getVisitById(id);
	}

}
