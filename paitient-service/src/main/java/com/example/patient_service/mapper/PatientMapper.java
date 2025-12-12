package com.example.patient_service.mapper;

import com.example.patient_service.dto.PatientRequestDTO;
import com.example.patient_service.dto.PatientResponseDTO;
import com.example.patient_service.model.Patient;

import java.time.LocalDate;
import java.time.LocalDateTime;

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

    public static Patient toModel(PatientRequestDTO patientRequestDTO){
        Patient patient = new Patient();
        patient.setName(patientRequestDTO.getName());
        patient.setEmail(patientRequestDTO.getEmail());
        patient.setAddress(patientRequestDTO.getAddress());
        patient.setDateOfBirth(LocalDateTime.parse(patientRequestDTO.getDateOfBirth()));
        patient.setRegisteredDate(LocalDateTime.parse(patientRequestDTO.getRegisteredDate()));

        return patient;
    }
}
