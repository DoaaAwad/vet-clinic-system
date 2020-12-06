package com.doaa.vetclinic.services;

import java.math.BigDecimal;
import java.util.List;

import com.doaa.vetclinic.entities.Clinic;
import com.doaa.vetclinic.entities.Doctor;
import com.doaa.vetclinic.entities.Owner;
import com.doaa.vetclinic.entities.Pet;
import com.doaa.vetclinic.entities.Visit;

/**
 * @author doaa1
 *
 */

public interface VetClinicService {
	
	/**Owner Services**/
	
	public List<Owner> listAllOwners();

	public void saveOwner(Owner owner);

	public void deleteOwner(BigDecimal id);
	
	public Owner getOwnerById(BigDecimal id);
	

	
	/**Pet Services**/
	
	public List<Pet> listAllPets();
	
	public List<Pet> listPetsByOwnerId(BigDecimal ownerId);

	public void savePet(Pet pet);

	public void deletePet(BigDecimal id);
	
	public Pet getPetById(BigDecimal id);
	
	
	
	/**Clinic Services**/
	
	public List<Clinic> listAllClinics();
	
	public List<Clinic> searchClinicByPhone(BigDecimal phoneNum);
	
	public List<Clinic> searchClinicByAddress(String address);

	public void saveClinic(Clinic clinic);

	public void deleteClinic(BigDecimal id);
	
	public Clinic getClinicById(BigDecimal id);
	
	
	
	/**Doctor Services**/
	
	public List<Doctor> listAllDoctors();
	
	public List<Doctor> listDoctorsByClinicId(BigDecimal clinicId);
	
	public void saveDoctor(Doctor doctor);

	public void deleteDoctor(BigDecimal id);
	
	public Doctor getDoctorById(BigDecimal id);
	
	
	
	/**Visit Services**/
	
	public List<Visit> listAllVisits();
		
	public void saveVisit(Visit visit);

	public void deleteVisit(BigDecimal id);
	
	public Visit getVisitById(BigDecimal id);
	
}
