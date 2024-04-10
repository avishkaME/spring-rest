package com.example.restdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PatientController {
    @Autowired
    private PatientService patientService;

    @GetMapping("/")
    public String viewHomePage(Model model) {
        List<Patient> patients = patientService.getAllPatients();
        model.addAttribute("patients", patients);
        return "index";
    }

    @GetMapping("/showNewPatientForm")
    public String showNewPatientForm(Model model) {
        model.addAttribute("patient", new Patient());
        return "new_patient";
    }

    @PostMapping("/savePatient")
    public String savePatient(@ModelAttribute("patient") Patient patient) {
        patientService.saveOrUpdate(patient);
        return "redirect:/";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") Long id, Model model) {
        Patient patient = patientService.getPatientById(id);
        model.addAttribute("patient", patient);
        return "update_patient";
    }

    @GetMapping("/deletePatient/{id}")
    public String deletePatient(@PathVariable(value = "id") Long id) {
        patientService.delete(id);
        return "redirect:/";
    }
}
