/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.alims.pismaBack.service;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.alims.pismaBack.dto.LetterDTO;
import rs.alims.pismaBack.model.Admin;
import rs.alims.pismaBack.model.Letter;
import rs.alims.pismaBack.model.Medication;
import rs.alims.pismaBack.repository.AdminRepository;
import rs.alims.pismaBack.repository.LetterRepository;
import rs.alims.pismaBack.repository.MedicationRepository;

/**
 *
 * @author lazar
 */
@Service
public class LetterService {

    @Autowired
    private LetterRepository letterRepository;

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private MedicationRepository medicationRepository;

    public List<LetterDTO> getAllLettersDTO() {
        return letterRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .toList();
    }

    public LetterDTO convertToDTO(Letter letter) {
        List<String> medNames = letter.getMedications()
                .stream()
                .map(Medication::getName)
                .toList();

        return new LetterDTO(
                letter.getId(),
                letter.getTitle(),
                letter.getDescription(),
                letter.getContent(),
                letter.getDate(),
                letter.getAdmin().getFirstName() + " " + letter.getAdmin().getLastName(),
                medNames
        );
    }

    public Letter createLetterFromDTO(LetterDTO dto) {
        Letter letter = new Letter();
        letter.setTitle(dto.getTitle());
        letter.setDescription(dto.getDescription());
        letter.setContent(dto.getContent());
        letter.setDate(LocalDateTime.now());

        Admin admin = adminRepository.findById(dto.getAdminId())
                .orElseThrow(() -> new RuntimeException("Admin not found"));
        letter.setAdmin(admin);

        List<Medication> meds = medicationRepository.findAllById(dto.getMedicationIds());
        letter.setMedications(meds);

        return letterRepository.save(letter);
    }
}
