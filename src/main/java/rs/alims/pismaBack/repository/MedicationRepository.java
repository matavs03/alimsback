/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package rs.alims.pismaBack.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rs.alims.pismaBack.model.Medication;

/**
 *
 * @author lazar
 */
@Repository
public interface MedicationRepository extends JpaRepository<Medication, String>{
    
}
