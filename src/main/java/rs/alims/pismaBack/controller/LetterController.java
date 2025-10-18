/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.alims.pismaBack.controller;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rs.alims.pismaBack.dto.LetterDTO;
import rs.alims.pismaBack.model.Letter;
import rs.alims.pismaBack.repository.LetterRepository;
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
    private LetterRepository letterRepository;

    @Autowired
    private LetterService letterService;

    @GetMapping("/letters")
    public List<LetterDTO> getAllLetters() {
        return letterService.getAllLettersDTO();
    }

    @PostMapping("/letters")
    public LetterDTO createLetter(@RequestBody LetterDTO letterDTO) {
        Letter letter = letterService.createLetterFromDTO(letterDTO);
        return letterService.convertToDTO(letter);
    }

}
