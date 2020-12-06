/**
 * 
 */
package com.doaa.vetclinic.entities;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author doaa1
 *
 */
@Entity
@Table(name = "doctor")
public class Doctor {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="DOCTOR_ID")
	private int doctorId;
	
	@ManyToOne
	@JoinColumn(name = "CLINIC_ID")
	private Clinic clinic;
	
	@Column(name = "NAME")
	private String doctorName;
	
	@Column(name = "PHONE")
	private BigDecimal phone;
	
	@Column(name = "PHOTO_URL")
	private String photoUrl;
	
	@Column(name = "BIO")
	private String bio;

	@OneToMany(mappedBy = "doctor")
	private List<Visit> doctorVisits;

	public Doctor() {
	
	}

	public Doctor(int doctorId, Clinic clinic, String doctorName, BigDecimal phone, String photoUrl, String bio) {
		this.doctorId = doctorId;
		this.clinic = clinic;
		this.doctorName = doctorName;
		this.phone = phone;
		this.photoUrl = photoUrl;
		this.bio = bio;
	}

	public int getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}

	public Clinic getClinic() {
		return clinic;
	}

	public void setClinic(Clinic clinic) {
		this.clinic = clinic;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public BigDecimal getPhone() {
		return phone;
	}

	public void setPhone(BigDecimal phone) {
		this.phone = phone;
	}

	public String getPhotoUrl() {
		return photoUrl;
	}

	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	public List<Visit> getDoctorVisits() {
		return doctorVisits;
	}

	public void setDoctorVisits(List<Visit> doctorVisits) {
		this.doctorVisits = doctorVisits;
	}
	
}
