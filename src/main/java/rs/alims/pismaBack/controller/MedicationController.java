/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.alims.pismaBack.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import rs.alims.pismaBack.model.Medication;
import rs.alims.pismaBack.repository.MedicationRepository;

/**
 *
 * @author lazar
 */
@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = {
    "http://localhost:4200",   // Angular
    "http://localhost:5173"
})
public class MedicationController {
    
    @Autowired
    private MedicationRepository medicationRepository;
    
    @GetMapping("/medications")
    public List<Medication> getAllMedication(){
        return medicationRepository.findAll();
    }
    
    
    
}
