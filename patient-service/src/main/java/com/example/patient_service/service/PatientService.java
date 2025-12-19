package com.example.patient_service.service;


import com.example.patient_service.dto.PatientRequestDTO;
import com.example.patient_service.dto.PatientResponseDTO;
import com.example.patient_service.exception.EmailAlreadyExistsException;
import com.example.patient_service.exception.PatientNotFoundException;
import com.example.patient_service.grpc.BillingServiceGrpcClient;
import com.example.patient_service.kafka.KafkaProducer;
import com.example.patient_service.mapper.PatientMapper;
import com.example.patient_service.model.Patient;
import com.example.patient_service.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PatientService {
    private final PatientRepository patientRepository;
    private final BillingServiceGrpcClient billingServiceGrpcClient;
    private final KafkaProducer kafkaProducer;

    public List<PatientResponseDTO> getPatients() {
        List<Patient> patients = patientRepository.findAll();

        return patients.stream()
                .map(PatientMapper::toDto).toList();
    }

    public PatientResponseDTO createPatient(PatientRequestDTO patient) {
        if (patientRepository.existsByEmail(patient.getEmail())) {
            throw new EmailAlreadyExistsException("A patient with this email already exists" + patient.getEmail());
        }
        Patient newPatient = patientRepository.save(PatientMapper.toModel(patient));

        billingServiceGrpcClient.createBillingAccount(newPatient.getId().toString(),
                newPatient.getName(), newPatient.getEmail());

        kafkaProducer.sendEvent(newPatient);

        return PatientMapper.toDto(newPatient);
    }

    public PatientResponseDTO updatePatient(UUID id, PatientRequestDTO patient) {
        Patient updatedPatient = patientRepository.findById(id).orElseThrow(
                () -> new PatientNotFoundException("Patient Not found with id: " + id));
        if (patientRepository.existsByEmailAndIdNot(patient.getEmail(), id)) {
            throw new EmailAlreadyExistsException("A patient with this email already exists" + patient.getEmail());
        }
        updatedPatient.setEmail(patient.getEmail());
        updatedPatient.setName(patient.getName());
        updatedPatient.setAddress(patient.getAddress());
        updatedPatient.setDateOfBirth(LocalDateTime.parse(patient.getDateOfBirth()));

        Patient updatedPatientUpdated = patientRepository.save(updatedPatient);
        return PatientMapper.toDto(updatedPatientUpdated);
    }

    public void deletePatient(UUID id) {
        patientRepository.deleteById(id);
    }
}
