package com.example.patient_service.mapper;

import com.example.patient_service.dto.PatientResponseDTO;
import com.example.patient_service.model.Patient;

public class PatientMapper {

    public static PatientResponseDTO toDto(Patient paitient){
        PatientResponseDTO patientResponseDTO = new PatientResponseDTO();

        patientResponseDTO.setId(paitient.getId().toString());
        patientResponseDTO.setName(paitient.getName());
        patientResponseDTO.setEmail(paitient.getEmail());
        patientResponseDTO.setAddress(paitient.getAddress());
        patientResponseDTO.setDateOfBirth(paitient.getDateOfBirth().toString());

        return patientResponseDTO;
    }
}
