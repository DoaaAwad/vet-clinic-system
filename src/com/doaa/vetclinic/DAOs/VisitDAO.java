/**
 * 
 */
package com.doaa.vetclinic.DAOs;

import java.util.List;

import com.doaa.vetclinic.entities.Visit;

/**
 * @author doaa1
 *
 */
public interface VisitDAO {

	public List<Visit> listAllVisits();
	
	public void saveVisit(Visit visit);

	public void deleteVisit(int id);
	
	public Visit getVisitById(int id);
}
