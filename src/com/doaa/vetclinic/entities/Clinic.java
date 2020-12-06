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
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author doaa1
 *
 */
@Entity
@Table(name = "clinic")
public class Clinic {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CLINIC_ID")
	private int clinicId;
	
	@Column(name = "NAME")
	private String clinicName;
	
	@Column(name = "WORKING_DAYS_AND_HOURS")
	private String workingDaysAndHours;
	
	@Column(name = "PHONE")
	private BigDecimal phone;
	
	@Column(name = "EMAIL")
	private String email;
	
	@Column(name = "ADDRESS")
	private String address;
	
	@Column(name = "SOCIAL_NETWORK_URLS")
	private String socialNetworkURLs;
	
	@OneToMany(mappedBy = "clinic")
	private List<Visit> clinicVisits;

	public Clinic() {

	}

	public Clinic(int clinicId, String clinicName, String workingDaysAndHours, BigDecimal phone, String email,
			String address, String socialNetworkURLs) {
		super();
		this.clinicId = clinicId;
		this.clinicName = clinicName;
		this.workingDaysAndHours = workingDaysAndHours;
		this.phone = phone;
		this.email = email;
		this.address = address;
		this.socialNetworkURLs = socialNetworkURLs;
	}

	public int getClinicId() {
		return clinicId;
	}

	public void setClinicId(int clinicId) {
		this.clinicId = clinicId;
	}

	public String getClinicName() {
		return clinicName;
	}

	public void setClinicName(String clinicName) {
		this.clinicName = clinicName;
	}

	public String getWorkingDaysAndHours() {
		return workingDaysAndHours;
	}

	public void setWorkingDaysAndHours(String workingDaysAndHours) {
		this.workingDaysAndHours = workingDaysAndHours;
	}

	public BigDecimal getPhone() {
		return phone;
	}

	public void setPhone(BigDecimal phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getSocialNetworkURLs() {
		return socialNetworkURLs;
	}

	public void setSocialNetworkURLs(String socialNetworkURLs) {
		this.socialNetworkURLs = socialNetworkURLs;
	}

	public List<Visit> getClinicVisits() {
		return clinicVisits;
	}

	public void setClinicVisits(List<Visit> clinicVisits) {
		this.clinicVisits = clinicVisits;
	}
	
}
