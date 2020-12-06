/**
 * 
 */
package com.doaa.vetclinic.DAOs;

import java.util.List;

import com.doaa.vetclinic.entities.Doctor;

/**
 * @author doaa1
 *
 */
public interface DoctorDAO {
	
	public List<Doctor> listAllDoctors();
	
	public List<Doctor> listDoctorsByClinicId(int clinicId);
	
	public void saveDoctor(Doctor doctor);

	public void deleteDoctor(int id);
	
	public Doctor getDoctorById(int id);

}
