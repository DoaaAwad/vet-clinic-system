package com.doaa.vetclinic.services;

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

	public void deleteOwner(int id);
	
	public Owner getOwnerById(int id);
	

	
	/**Pet Services**/
	
	public List<Pet> listAllPets();
	
	public List<Pet> listPetsByOwnerId(int ownerId);

	public void savePet(Pet pet);

	public void deletePet(int id);
	
	public Pet getPetById(int id);
	
	
	
	/**Clinic Services**/
	
	public List<Clinic> listAllClinics();
	
	public List<Clinic> searchClinicByPhone(int phoneNum);
	
	public List<Clinic> searchClinicByAddress(String address);

	public void saveClinic(Clinic clinic);

	public void deleteClinic(int id);
	
	public Clinic getClinicById(int id);
	
	
	
	/**Doctor Services**/
	
	public List<Doctor> listAllDoctors();
	
	public List<Doctor> listDoctorsByClinicId(int clinicId);
	
	public void saveDoctor(Doctor doctor);

	public void deleteDoctor(int id);
	
	public Doctor getDoctorById(int id);
	
	
	
	/**Visit Services**/
	
	public List<Visit> listAllVisits();
		
	public void saveVisit(Visit visit);

	public void deleteVisit(int id);
	
	public Visit getVisitById(int id);
	
}
