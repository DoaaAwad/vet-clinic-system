/**
 * 
 */
package com.doaa.vetclinic.DAOs;

import java.math.BigDecimal;
import java.util.List;

import com.doaa.vetclinic.entities.Clinic;

/**
 * @author doaa1
 *
 */
public interface ClinicDAO {

	public List<Clinic> listAllClinics();
	
	public List<Clinic> searchClinicByPhone(BigDecimal phoneNum);
	
	public List<Clinic> searchClinicByAddress(String address);

	public void saveClinic(Clinic clinic);

	public void deleteClinic(BigDecimal id);
	
	public Clinic getClinicById(BigDecimal id);
}
