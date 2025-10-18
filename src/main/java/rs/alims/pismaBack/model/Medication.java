/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.alims.pismaBack.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 *
 * @author lazar
 */
@Entity
@Table(name = "medication")
public class Medication {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "inn", length = 2000)
    private String inn;

    @Column(name = "dosage_form", length = 1000)
    private String dosage_form;

    @Column(name = "manufacturer", length = 1000)
    private String manufacturer;

    @Column(name = "name", length = 500)
    private String name;

    public Medication() {
    }

    public Medication(String id, String name, String manufacturer, String inn, String dosage_form) {
        this.id = id;
        this.name = name;
        this.manufacturer = manufacturer;
        this.inn = inn;
        this.dosage_form = dosage_form;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getInn() {
        return inn;
    }

    public void setInn(String inn) {
        this.inn = inn;
    }

    public String getDosage_form() {
        return dosage_form;
    }

    public void setDosage_form(String dosage_form) {
        this.dosage_form = dosage_form;
    }

}
