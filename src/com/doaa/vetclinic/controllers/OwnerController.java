/**
 * 
 */
package com.doaa.vetclinic.controllers;

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
import com.doaa.vetclinic.services.VetClinicService;

/**
 * @author doaa1
 *
 */
@Controller
@RequestMapping("/owner")
public class OwnerController {
	
	@Autowired
	private VetClinicService vetClinicService;
	
	@GetMapping("/list")
	public String listOwners(Model model) {
		
		List<Owner> owners=vetClinicService.listAllOwners();
		
		model.addAttribute("owners" ,owners);
		
		return "list-owners";
	}
	
	@GetMapping("/showFormToAddOwner")
	public String showFormToAddOwner(Model model) {
		
		Owner owner=new Owner();
		model.addAttribute("owner", owner);
		
		return "owner-form";
	}
	
	@PostMapping("/saveOwner")
	public String saveOwner(@ModelAttribute("owner") Owner owner) {
		
		vetClinicService.saveOwner(owner);
		
		return"redirect:/owner/list";
	}
	
	@GetMapping("/showFormToUpdate")
	public String showFormToUpdate(@RequestParam("ownerId") int id , Model model) {
		
		Owner owner = vetClinicService.getOwnerById(id);
		
		model.addAttribute("owner", owner);
		
		return "owner-form";
	}
	
	@GetMapping("/deleteOwner")
	public String deleteOwner(@RequestParam("ownerId") int id , Model model) {
		
		vetClinicService.deleteOwner(id);
		
		return "redirect:/owner/list";
	}
	
	
	@GetMapping("/searchByOwnerId")
	public String searchByOwnerId(@RequestParam("ownerId") int ownerId ,Model model) {
		
		Owner owner=vetClinicService.getOwnerById(ownerId);
		
		model.addAttribute("owner" , owner);
		
		return "list-owners";	
	}
}
