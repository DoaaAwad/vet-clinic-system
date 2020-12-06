/**
 * 
 */
package com.doaa.vetclinic.entities;

import java.math.BigDecimal;
import java.util.Date;
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
@Table(name = "pet")
public class Pet {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="PET_ID")
	private BigDecimal petId;
		
	@ManyToOne
	@JoinColumn(name = "OWNER_ID")
	private Owner owner;
	
	@Column(name = "NAME")
	private String petName;
	
	@Column(name = "GENDER")
	private String gender;
	
	@Column(name = "BIRTH_DATE")
	private Date birthDate;
	
	@Column(name = "ANIMAL_KIND")
	private String animalKind;
	
	@Column(name = "PHOTO_1_URL")
	private String photoURL1;
	
	@Column(name = "PHOTO_2_URL")
	private String photoURL2;

	@Column(name = "PHOTO_3_URL")
	private String photoURL3;

	@Column(name = "WEIGHT")
	private BigDecimal weight;
	
	@OneToMany(mappedBy = "pet")
	private List<Visit> petVisits;

	public Pet() {

	}

	public Pet(BigDecimal petId, Owner owner, String petName, String gender, Date birthDate, String animalKind,
			String photoURL1, String photoURL2, String photoURL3, BigDecimal weight) {
		this.petId = petId;
		this.owner = owner;
		this.petName = petName;
		this.gender = gender;
		this.birthDate = birthDate;
		this.animalKind = animalKind;
		this.photoURL1 = photoURL1;
		this.photoURL2 = photoURL2;
		this.photoURL3 = photoURL3;
		this.weight = weight;
	}

	public BigDecimal getPetId() {
		return petId;
	}

	public void setPetId(BigDecimal petId) {
		this.petId = petId;
	}

	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}

	public String getPetName() {
		return petName;
	}

	public void setPetName(String petName) {
		this.petName = petName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getAnimalKind() {
		return animalKind;
	}

	public void setAnimalKind(String animalKind) {
		this.animalKind = animalKind;
	}

	public String getPhotoURL1() {
		return photoURL1;
	}

	public void setPhotoURL1(String photoURL1) {
		this.photoURL1 = photoURL1;
	}

	public String getPhotoURL2() {
		return photoURL2;
	}

	public void setPhotoURL2(String photoURL2) {
		this.photoURL2 = photoURL2;
	}

	public String getPhotoURL3() {
		return photoURL3;
	}

	public void setPhotoURL3(String photoURL3) {
		this.photoURL3 = photoURL3;
	}

	public BigDecimal getWeight() {
		return weight;
	}

	public void setWeight(BigDecimal weight) {
		this.weight = weight;
	}

}
