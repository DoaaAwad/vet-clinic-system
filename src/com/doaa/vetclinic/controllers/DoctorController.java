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
import com.doaa.vetclinic.services.VetClinicService;

/**
 * @author doaa1
 *
 */
@Controller
@RequestMapping("/doctor")
public class DoctorController {
	
	@Autowired
	private VetClinicService vetClinicService;
	
	@GetMapping("/list")
	public String listDoctors(Model model) {
		
		List<Doctor> doctors=vetClinicService.listAllDoctors();
		
		model.addAttribute("doctors" ,doctors);
		
		return "list-doctors";
	}
	@GetMapping("/showFormToAddDoctor")
	public String showFormToAddDoctor(Model model) {
		
		List<Clinic> clinicsList = vetClinicService.listAllClinics();
		model.addAttribute("clinicsList", clinicsList);
		
		Doctor doctor=new Doctor();
		model.addAttribute("doctor", doctor);
		
		return "doctor-form";
	}
	
	@PostMapping("/saveDoctor")
	public String saveDoctor(@ModelAttribute("doctor") Doctor doctor) {
		
		vetClinicService.saveDoctor(doctor);
		
		return"redirect:/doctor/list";
	}
	
	@GetMapping("/showFormToUpdate")
	public String showFormToUpdate(@RequestParam("doctorId") int id , Model model) {
		
		List<Clinic> clinicsList = vetClinicService.listAllClinics();
		model.addAttribute("clinicsList", clinicsList);
		
		Doctor doctor = vetClinicService.getDoctorById(id);
		
		model.addAttribute("doctor", doctor);
		
		return "doctor-form";
	}
	
	@GetMapping("/deleteDoctor")
	public String deleteDoctor(@RequestParam("doctorId") int id , Model model) {
		
		vetClinicService.deleteDoctor(id);
		
		return "redirect:/doctor/list";
	}
	
	@GetMapping("/searchDoctorsByClinicId")
	public String searchDoctorsByClinicId(@RequestParam("clinicId") int clinicId ,Model model) {
		
		List<Doctor> doctors=vetClinicService.listDoctorsByClinicId(clinicId);
		
		model.addAttribute("doctors" , doctors);
		
		return "list-doctors";	
	}
	
	@GetMapping("/searchDoctorsByDoctorId")
	public String searchDoctorsByDoctorId(@RequestParam("doctorId") int doctorId ,Model model) {
		
		Doctor doctor=vetClinicService.getDoctorById(doctorId);
		
		model.addAttribute("doctor" , doctor);
		
		return "list-doctors";	
	}
}
