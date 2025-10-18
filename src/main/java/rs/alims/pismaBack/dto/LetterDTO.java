/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.alims.pismaBack.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.LocalDateTime;
import java.util.List;

/**
 *
 * @author lazar
 */
public class LetterDTO {
    private Long id;
    private String title;
    private String description;
    private String content;
    private LocalDateTime date;
    private String adminName;
    private List<String> medicationNames;
    private Long adminId;
    private List<String> medicationIds;

    public LetterDTO() {
    }

    public LetterDTO(Long id, String title, String description, String content, LocalDateTime date, String adminName, List<String> medicationNames) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.content = content;
        this.date = date;
        this.adminName = adminName;
        this.medicationNames = medicationNames;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public List<String> getMedicationNames() {
        return medicationNames;
    }

    public void setMedicationNames(List<String> medicationNames) {
        this.medicationNames = medicationNames;
    }

    public Long getAdminId() {
        return adminId;
    }

    public void setAdminId(Long adminId) {
        this.adminId = adminId;
    }

    public List<String> getMedicationIds() {
        return medicationIds;
    }

    public void setMedicationIds(List<String> medicationIds) {
        this.medicationIds = medicationIds;
    }
    
    
}
