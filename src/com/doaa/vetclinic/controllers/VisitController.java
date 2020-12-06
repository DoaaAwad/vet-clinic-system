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

import com.doaa.vetclinic.entities.Clinic;
import com.doaa.vetclinic.entities.Doctor;
import com.doaa.vetclinic.entities.Pet;
import com.doaa.vetclinic.entities.Visit;
import com.doaa.vetclinic.services.VetClinicService;

/**
 * @author doaa1
 *
 */
@Controller
@RequestMapping("/visit")
public class VisitController {

	@Autowired
	private VetClinicService vetClinicService;
	
	@GetMapping("/list")
	public String listVisits(Model model) {
		
		List<Visit> visits=vetClinicService.listAllVisits();
		
		model.addAttribute("visits" ,visits);
		
		return "list-visits";
	}
	
	@GetMapping("/showFormToAddVisit")
	public String showFormToAddVisit(Model model) {
		List<Doctor> doctorsList = vetClinicService.listAllDoctors();
		List<Clinic> clinicList = vetClinicService.listAllClinics();
		List<Pet> petList =vetClinicService.listAllPets();
		Visit visit=new Visit();
		model.addAttribute("visit", visit);
		model.addAttribute("doctorsList", doctorsList);
		model.addAttribute("clinicList", clinicList);
		model.addAttribute("petList", petList);
		return "visit-form";
	}
	
	@PostMapping("/saveVisit")
	public String saveVisit(@ModelAttribute("visit") Visit visit) {
		
		vetClinicService.saveVisit(visit);
		
		return"redirect:/visit/list";
	}
	
	@PostMapping("/showFormToUpdate")
	public String showFormToUpdate(@RequestParam("visitId") int id , Model model) {
		List<Doctor> doctorsList = vetClinicService.listAllDoctors();
		List<Clinic> clinicList = vetClinicService.listAllClinics();
		List<Pet> petList =vetClinicService.listAllPets();
		
		model.addAttribute("doctorsList", doctorsList);
		model.addAttribute("clinicList", clinicList);
		model.addAttribute("petList", petList);
		
		Visit visit = vetClinicService.getVisitById(id);
		
		model.addAttribute("visit", visit);
		
		return "visit-form";
	}
	
	@GetMapping("/deleteVisit")
	public String deleteVisit(@RequestParam("visitId") int id , Model model) {
		
		vetClinicService.deleteVisit(id);
		
		return "redirect:/visit/list";
	}
	
	
	@GetMapping("/searchByVisitId")
	public String searchByVisitId(@RequestParam("visitId") int visitId ,Model model) {
		
		Visit visit=vetClinicService.getVisitById(visitId);
		
		model.addAttribute("visit" , visit);
		
		return "list-visits";	
	}
}
