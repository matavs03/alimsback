/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.alims.pismaBack.controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import rs.alims.pismaBack.dto.LetterDTO;
import rs.alims.pismaBack.model.Admin;
import rs.alims.pismaBack.model.Letter;
import rs.alims.pismaBack.model.Medication;
import rs.alims.pismaBack.repository.AdminRepository;
import rs.alims.pismaBack.repository.LetterRepository;
import rs.alims.pismaBack.repository.MedicationRepository;
import rs.alims.pismaBack.service.LetterService;

/**
 *
 * @author lazar
 */
@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "http://localhost:4200")
public class LetterController {

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private MedicationRepository medicationRepository;

    @Autowired
    private LetterRepository letterRepository;

    @Autowired
    private LetterService letterService;

    @GetMapping("/letters")
    public List<LetterDTO> getAllLetters() {
        return letterService.getAllLettersDTO();
    }

    @PostMapping(value = "/letters", consumes = {"multipart/form-data"})
    public LetterDTO uploadLetter(
            @RequestPart("letter") LetterDTO letterDTO,
            @RequestPart("file") MultipartFile file) throws IOException {

        Letter letter = letterService.createLetterFromDTO(letterDTO, file);
        return letterService.convertToDTO(letter);
    }

    @GetMapping("/letters/{id}/download")
    public ResponseEntity<byte[]> downloadLetter(@PathVariable Long id) {
        Letter letter = letterRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Letter not found"));

        return ResponseEntity.ok()
            .header(HttpHeaders.CONTENT_TYPE, "application/pdf")
            .body(letter.getContent());
    }

}
