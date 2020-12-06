/**
 * 
 */
package com.doaa.vetclinic.controllers;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.doaa.vetclinic.entities.Owner;
import com.doaa.vetclinic.entities.Pet;
import com.doaa.vetclinic.services.VetClinicService;


/**
 * @author doaa1
 *
 */
@Controller
@RequestMapping("/pet")
public class PetController {

	@Autowired
	private VetClinicService vetClinicService;
	
	@GetMapping("/list")
	public String listPets(Model model) {
		
		List<Pet> pets=vetClinicService.listAllPets();
		
		model.addAttribute("pets" ,pets);
		
		return "list-pets";
	}
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model model) {
		
		List<Owner> ownersList = vetClinicService.listAllOwners();
		model.addAttribute("ownersList", ownersList);
		
		Pet pet=new Pet();
		model.addAttribute("pet", pet);
		
		return "pet-form";
	}
	
	@PostMapping("/savePet")
	public String savePet(@ModelAttribute("pet") Pet pet) {
		
		vetClinicService.savePet(pet);
		
		return"redirect:/pet/list";
	}
	
	@GetMapping("/showFormToUpdate")
	public String showFormToUpdate(@RequestParam("petId") BigDecimal id , Model model) {
		
		List<Owner> ownersList = vetClinicService.listAllOwners();
		model.addAttribute("ownersList", ownersList);
		
		Pet pet = vetClinicService.getPetById(id);
		
		model.addAttribute("pet", pet);
		
		return "pet-form";
	}
	
	@GetMapping("/deletePet")
	public String deletePet(@RequestParam("petId") BigDecimal id , Model model) {
		
		vetClinicService.deletePet(id);
		
		return "redirect:/pet/list";
	}
	
	@GetMapping("/searchPetsByOwnerId")
	public String searchPetsByOwnerId(@RequestParam("ownerId") BigDecimal ownerId ,Model model) {
		
		List<Pet> pets=vetClinicService.listPetsByOwnerId(ownerId);
		
		model.addAttribute("pets" , pets);
		
		return "list-pets";	
	}
	
	@GetMapping("/searchPetsByPetId")
	public String searchPetsByPetId(@RequestParam("petId") BigDecimal petId ,Model model) {
		
		Pet pet=vetClinicService.getPetById(petId);
		
		model.addAttribute("pet" , pet);
		
		return "list-pets";	
	}
}
