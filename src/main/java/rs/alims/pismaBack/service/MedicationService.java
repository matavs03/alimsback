/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.alims.pismaBack.service;

import jakarta.annotation.PostConstruct;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import rs.alims.pismaBack.dto.MedicationDTO;
import rs.alims.pismaBack.dto.MedicationResponse;
import rs.alims.pismaBack.model.Medication;
import rs.alims.pismaBack.repository.MedicationRepository;

/**
 *
 * @author lazar
 */
@Service
public class MedicationService {

    @Autowired
    private MedicationRepository medicationRepository;

    @Autowired
    private RestTemplate restTemplate;

    private static final String API_URL = "https://api.alims.gov.rs/RegistarLekovaHumanaMedicinaREST/registarlekovahumanamedicina";

    @PostConstruct
    public void init() {
        updateMedications();
    }

    public void updateMedications() {
        try {
            MedicationResponse response = restTemplate.getForObject(API_URL, MedicationResponse.class);

            List<MedicationDTO> dtos = response.getLekovi(); 

            if (dtos != null) {
                for (MedicationDTO dto : dtos) {
                    Medication med = new Medication();
                    med.setId(dto.getSifraProizvoda());
                    med.setName(dto.getNazivLeka());
                    med.setManufacturer(dto.getProizvodjac());
                    med.setInn(dto.getInn());
                    med.setDosage_form(dto.getOblikIDozaLeka());

                    medicationRepository.save(med);
                }
            }

            System.out.println("Lekovi uspesno azurirani.");

        } catch (Exception e) {
            System.err.println("Greska pri citanju API-ja: " + e.getMessage());
        }

    }

    @Scheduled(fixedRate = 24 * 60 * 60 * 1000)
    public void scheduledUpdate() {
        System.out.println("Automatsko azuriranje lekova...");
        updateMedications();
    }

}
