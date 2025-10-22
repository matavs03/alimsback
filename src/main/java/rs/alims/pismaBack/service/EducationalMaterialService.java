/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.alims.pismaBack.service;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import rs.alims.pismaBack.dto.EducationalMaterialDTO;
import rs.alims.pismaBack.dto.FileDTO;
import rs.alims.pismaBack.model.Admin;
import rs.alims.pismaBack.model.EducationalMaterial;
import rs.alims.pismaBack.model.MaterialFile;
import rs.alims.pismaBack.repository.AdminRepository;
import rs.alims.pismaBack.repository.EducationalMaterialRepository;
import rs.alims.pismaBack.repository.MaterialFileRepository;

/**
 *
 * @author lazar
 */
@Service
public class EducationalMaterialService {

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private EducationalMaterialRepository materialRepository;

    @Autowired
    private MaterialFileRepository fileRepository;

    public List<EducationalMaterialDTO> getAllMaterials() {
        return materialRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public EducationalMaterial createMaterial(EducationalMaterialDTO dto, List<MultipartFile> files) throws IOException {
        Admin admin = adminRepository.findById(dto.getAdminId())
                .orElseThrow(() -> new RuntimeException("Admin not found"));

        EducationalMaterial material = new EducationalMaterial(
                dto.getTitle(),
                dto.getDescription(),
                LocalDateTime.now(),
                admin
        );

        List<MaterialFile> fileEntities = new ArrayList<>();
        for (MultipartFile file : files) {
            MaterialFile mf = new MaterialFile(file.getOriginalFilename(), file.getContentType(), file.getBytes());
            mf.setEducationalMaterial(material);
            fileEntities.add(mf);
        }
        material.setFiles(fileEntities);

        return materialRepository.save(material);
    }

    public EducationalMaterialDTO convertToDTO(EducationalMaterial material) {
        List<FileDTO> fileDTOs = material.getFiles().stream()
                .map(f -> new FileDTO(f.getFileName(), f.getFileType()))
                .collect(Collectors.toList());

        return new EducationalMaterialDTO(
                material.getId(),
                material.getTitle(),
                material.getDescription(),
                material.getDate(),
                material.getAdmin().getUsername(),
                material.getAdmin().getId(),
                fileDTOs
        );
    }

    public ResponseEntity<byte[]> downloadFile(Long materialId, Long fileId) {
        MaterialFile file = fileRepository.findById(fileId)
                .orElseThrow(() -> new RuntimeException("File not found"));

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_TYPE, file.getFileType())
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFileName() + "\"")
                .body(file.getContent());
    }
}
