package com.example.paitient_service.model;

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

    @NotNull
    private String name;

    @NotNull
    @Email
    @Column(updatable = true)
    private String email;

    @NotNull
    private String address;

    @NotNull
    private LocalDateTime dateOfBirth;

    @NotNull
    private LocalDateTime registeredDate;

}
