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
    private String fileName;
    private LocalDateTime date;
    private String adminName;
    private List<String> medicationNames;
    private Long adminId;
    private List<String> medicationIds;

    public LetterDTO() {
    }

    public LetterDTO(Long id, String title, String description, String fileName, LocalDateTime date, String adminName, List<String> medicationNames, Long adminId, List<String> medicationIds) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.fileName = fileName;
        this.date = date;
        this.adminName = adminName;
        this.medicationNames = medicationNames;
        this.adminId = adminId;
        this.medicationIds = medicationIds;
    }

    public LetterDTO(
            Long id,
            String title,
            String description,
            String fileName,
            LocalDateTime date,
            String adminName,
            List<String> medicationNames
    ) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.fileName = fileName;
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

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
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
