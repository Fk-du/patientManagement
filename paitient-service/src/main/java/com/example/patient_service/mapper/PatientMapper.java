package com.example.paitient_service.mapper;

import com.example.paitient_service.dto.PaitientResponseDTO;
import com.example.paitient_service.model.Patient;

public class PaitientMapper {

    public static PaitientResponseDTO toDto(Patient paitient){
        PaitientResponseDTO paitientResponseDTO = new PaitientResponseDTO();

        paitientResponseDTO.setId(paitient.getId().toString());
        paitientResponseDTO.setName(paitient.getName());
        paitientResponseDTO.setEmail(paitient.getEmail());
        paitientResponseDTO.setAddress(paitient.getAddress());
        paitientResponseDTO.setDateOfBirth(paitient.getDateOfBirth().toString());

        return paitientResponseDTO;
    }
}
