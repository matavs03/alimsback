/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.alims.pismaBack.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/**
 *
 * @author lazar
 */
public class MedicationResponse {
    
    @JsonProperty("lekovi")
    private List<MedicationDTO> lekovi;

    public List<MedicationDTO> getLekovi() { return lekovi; }
    public void setLekovi(List<MedicationDTO> lekovi) { this.lekovi = lekovi; }
    
}
