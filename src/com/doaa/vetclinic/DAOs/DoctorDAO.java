/**
 * 
 */
package com.doaa.vetclinic.DAOs;

import java.math.BigDecimal;
import java.util.List;

import com.doaa.vetclinic.entities.Doctor;

/**
 * @author doaa1
 *
 */
public interface DoctorDAO {
	
	public List<Doctor> listAllDoctors();
	
	public List<Doctor> listDoctorsByClinicId(BigDecimal clinicId);
	
	public void saveDoctor(Doctor doctor);

	public void deleteDoctor(BigDecimal id);
	
	public Doctor getDoctorById(BigDecimal id);

}
