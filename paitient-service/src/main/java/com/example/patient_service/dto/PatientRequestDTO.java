package com.example.patient_service.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

@Data
public class PatientRequestDTO {
    @NotNull(message = "Name is required")
    @Size(max = 100, message = "max is 100 chars")
    private String name;

    @NotNull(message = "Email is required")
    @Email(message = "email should be valid")
    private String email;

    @NotNull(message = "Address is required")
    private String address;

    @NotNull(message = "Date of birt is required")
    private String dateOfBirth;

    @NotNull(message = "Registered date is required")
    private String registeredDate;


}
