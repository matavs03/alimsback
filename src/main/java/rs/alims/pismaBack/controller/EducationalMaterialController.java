/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.alims.pismaBack.controller;

import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import rs.alims.pismaBack.dto.EducationalMaterialDTO;
import rs.alims.pismaBack.model.EducationalMaterial;
import rs.alims.pismaBack.service.EducationalMaterialService;

/**
 *
 * @author lazar
 */
@RestController
@RequestMapping("/api/v1/materials")
@CrossOrigin(origins = "http://localhost:5173")
public class EducationalMaterialController {

    @Autowired
    private EducationalMaterialService materialService;

    @GetMapping
    public List<EducationalMaterialDTO> getAllMaterials() {
        return materialService.getAllMaterials();
    }

    @PostMapping(consumes = {"multipart/form-data"})
    public EducationalMaterialDTO uploadMaterial(
            @RequestPart("material") EducationalMaterialDTO materialDTO,
            @RequestPart("files") List<MultipartFile> files) throws IOException {

        EducationalMaterial material = materialService.createMaterial(materialDTO, files);
        return materialService.convertToDTO(material);
    }

    @GetMapping("/{id}/download/{fileId}")
    public ResponseEntity<byte[]> downloadFile(@PathVariable Long id, @PathVariable Long fileId) {
        return materialService.downloadFile(id, fileId);
    }
}
