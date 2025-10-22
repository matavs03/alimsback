/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.alims.pismaBack.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 *
 * @author lazar
 */
@Entity
@Table(name = "material_file")
public class MaterialFile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fileName;

    private String fileType;

    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private byte[] content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "educational_material_id")
    private EducationalMaterial educationalMaterial;

    public MaterialFile() {}

    public MaterialFile(String fileName, String fileType, byte[] content) {
        this.fileName = fileName;
        this.fileType = fileType;
        this.content = content;
    }


    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getFileName() { return fileName; }

    public void setFileName(String fileName) { this.fileName = fileName; }

    public String getFileType() { return fileType; }

    public void setFileType(String fileType) { this.fileType = fileType; }

    public byte[] getContent() { return content; }

    public void setContent(byte[] content) { this.content = content; }

    public EducationalMaterial getEducationalMaterial() { return educationalMaterial; }

    public void setEducationalMaterial(EducationalMaterial educationalMaterial) { this.educationalMaterial = educationalMaterial; }
}
