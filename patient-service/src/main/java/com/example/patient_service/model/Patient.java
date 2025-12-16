package com.example.patient_service.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @NotNull(message = "name is required")
    private String name;

    @NotNull(message = "email is required")
    @Email(message = "Email is required")
    private String email;

    @NotNull(message = "address is required")
    private String address;

    @NotNull(message = "date of Birth is required")
    private LocalDateTime dateOfBirth;

    @NotNull(message = "registered date is required")
    private LocalDateTime registeredDate;

}
