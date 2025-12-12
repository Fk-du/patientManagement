package com.example.paitient_service.service;


import com.example.paitient_service.dto.PaitientResponseDTO;
import com.example.paitient_service.mapper.PaitientMapper;
import com.example.paitient_service.model.Patient;
import com.example.paitient_service.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PaitientService {
    private final PatientRepository patientRepository;

    public List<PaitientResponseDTO> getPatients(){
        List<Patient> patients = patientRepository.findAll();

        return patients.stream()
                .map(PaitientMapper::toDto).toList();
    }
}
