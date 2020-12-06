/**
 * 
 */
package com.doaa.vetclinic.DAOs;

import java.util.List;

import com.doaa.vetclinic.entities.Clinic;

/**
 * @author doaa1
 *
 */
public interface ClinicDAO {

	public List<Clinic> listAllClinics();
	
	public List<Clinic> searchClinicByPhone(int phoneNum);
	
	public List<Clinic> searchClinicByAddress(String address);

	public void saveClinic(Clinic clinic);

	public void deleteClinic(int id);
	
	public Clinic getClinicById(int id);
}
