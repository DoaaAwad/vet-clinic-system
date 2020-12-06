/**
 * 
 */
package com.doaa.vetclinic.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author doaa1
 *
 */
@Entity
@Table(name = "visit")
public class Visit {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="VISIT_ID")
	private int visitId;
	
	@ManyToOne
	@JoinColumn(name = "DOCTOR_ID")
	private Doctor doctor;
	
	@ManyToOne
	@JoinColumn(name = "CLINIC_ID")
	private Clinic clinic;
	
	@ManyToOne
	@JoinColumn(name = "PET_ID")
	private Pet pet;
	
	@Column(name = "DATE")
	private Date visitDate;

	public Visit() {

	}

	public Visit(int visitId, Doctor doctor, Clinic clinic, Pet pet, Date visitDate) {
		super();
		this.visitId = visitId;
		this.doctor = doctor;
		this.clinic = clinic;
		this.pet = pet;
		this.visitDate = visitDate;
	}

	public int getVisitId() {
		return visitId;
	}

	public void setVisitId(int visitId) {
		this.visitId = visitId;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public Clinic getClinic() {
		return clinic;
	}

	public void setClinic(Clinic clinic) {
		this.clinic = clinic;
	}

	public Pet getPet() {
		return pet;
	}

	public void setPet(Pet pet) {
		this.pet = pet;
	}

	public Date getVisitDate() {
		return visitDate;
	}

	public void setVisitDate(Date visitDate) {
		this.visitDate = visitDate;
	}
	
}
