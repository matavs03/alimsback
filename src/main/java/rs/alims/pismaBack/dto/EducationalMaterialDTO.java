/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.alims.pismaBack.dto;

import java.time.LocalDateTime;
import java.util.List;

/**
 *
 * @author lazar
 */
public class EducationalMaterialDTO {

    private Long id;
    private String title;
    private String description;
    private LocalDateTime date;
    private String adminName;
    private Long adminId;
    private List<FileDTO> files;

    // 🔹 Novo:
    private List<String> medicationNames;
    private List<String> medicationIds;

    public EducationalMaterialDTO() {}

    public EducationalMaterialDTO(Long id, String title, String description, LocalDateTime date, String adminName, Long adminId, List<FileDTO> files, List<String> medicationNames, List<String> medicationIds) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.date = date;
        this.adminName = adminName;
        this.adminId = adminId;
        this.files = files;
        this.medicationNames = medicationNames;
        this.medicationIds = medicationIds;
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

    public Long getAdminId() {
        return adminId;
    }

    public void setAdminId(Long adminId) {
        this.adminId = adminId;
    }

    public List<FileDTO> getFiles() {
        return files;
    }

    public void setFiles(List<FileDTO> files) {
        this.files = files;
    }

    public List<String> getMedicationNames() {
        return medicationNames;
    }

    public void setMedicationNames(List<String> medicationNames) {
        this.medicationNames = medicationNames;
    }

    public List<String> getMedicationIds() {
        return medicationIds;
    }

    public void setMedicationIds(List<String> medicationIds) {
        this.medicationIds = medicationIds;
    }

    
}
