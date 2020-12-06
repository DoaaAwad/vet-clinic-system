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
import org.springframework.web.bind.annotation.RestController;

import com.doaa.vetclinic.entities.Clinic;
import com.doaa.vetclinic.services.VetClinicService;

/**
 * @author doaa1
 *
 */
@RestController
@Controller
@RequestMapping("/clinic")
public class ClinicController {
	@Autowired
	private VetClinicService vetClinicService;
	
	@GetMapping("/list")
	public String listClinics(Model model) {
		
		List<Clinic> clinics=vetClinicService.listAllClinics();
		
		model.addAttribute("clinics" ,clinics);
		
		return "list-clinics";
	}
	@GetMapping("/showFormToAddClinic")
	public String showFormToAddClinic(Model model) {
		
		Clinic clinic=new Clinic();
		model.addAttribute("clinic", clinic);
		
		return "clinic-form";
	}
	
	@PostMapping("/saveClinic")
	public String saveClinic(@ModelAttribute("clinic") Clinic clinic) {
		
		vetClinicService.saveClinic(clinic);
		
		return"redirect:/clinic/list";
	}
	
	@GetMapping("/showFormToUpdate")
	public String showFormToUpdate(@RequestParam("clinicId") BigDecimal id , Model model) {
		
		Clinic clinic = vetClinicService.getClinicById(id);
		
		model.addAttribute("clinic", clinic);
		
		return "clinic-form";
	}
	
	@GetMapping("/deleteClinic")
	public String deleteClinic(@RequestParam("clinicId") BigDecimal id , Model model) {
		
		vetClinicService.deleteClinic(id);
		
		return "redirect:/clinic/list";
	}
	
	@GetMapping("/searchClinicsByPhone")
	public String searchClinicsByPhone(@RequestParam("phone") BigDecimal phone ,Model model) {
		
		List<Clinic> clinics=vetClinicService.searchClinicByPhone(phone);
		
		model.addAttribute("clinics" , clinics);
		
		return "list-clinics";	
	}
	
	@GetMapping("/searchClinicsByAddress")
	public String searchClinicsByAddress(@RequestParam("address") String address ,Model model) {
		
		List<Clinic> clinics=vetClinicService.searchClinicByAddress(address);
		
		model.addAttribute("clinics" , clinics);
		
		return "list-clinics";	
	}
	
	@GetMapping("/searchClinicsByClinicId")
	public String searchClinicsByClinicId(@RequestParam("clinicId") BigDecimal clinicId ,Model model) {
		
		Clinic clinic = vetClinicService.getClinicById(clinicId);
		
		model.addAttribute("clinic" , clinic);
		
		return "list-clinics";	
	}
}
