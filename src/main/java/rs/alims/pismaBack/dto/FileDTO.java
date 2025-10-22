/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.alims.pismaBack.dto;

/**
 *
 * @author lazar
 */

public class FileDTO {
    private String fileName;
    private String fileType;

    public FileDTO() {}

    public FileDTO(String fileName, String fileType) {
        this.fileName = fileName;
        this.fileType = fileType;
    }

    public String getFileName() { return fileName; }

    public void setFileName(String fileName) { this.fileName = fileName; }

    public String getFileType() { return fileType; }

    public void setFileType(String fileType) { this.fileType = fileType; }
}
