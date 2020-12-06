/**
 * 
 */
package com.doaa.vetclinic.entities;

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
@Table(name = "owner")
public class Owner {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="OWNER_ID")
	private int ownerId;
	
	@Column(name = "NAME")
	private String ownerName;
	
	@Column(name = "GENDER")
	private String gender;
	
	@Column(name = "EMAIL")
	private String email;
	
	@Column(name = "PHONE")
	private int phone;
	
	@Column(name = "ADDRESS")
	private String address;
	
	@OneToMany(mappedBy = "owner")
	private List<Pet> ownerPets;
	
	public Owner() {
		
	}

	public Owner(int ownerId, String ownerName, String gender, String email, int phone, String address, List<Pet> ownerPets) {
		this.ownerId = ownerId;
		this.ownerName = ownerName;
		this.gender = gender;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.ownerPets = ownerPets;
	}

	public int getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<Pet> getOwnerPets() {
		return ownerPets;
	}

	public void setOwnerPets(List<Pet> ownerPets) {
		this.ownerPets = ownerPets;
	}
	
}
