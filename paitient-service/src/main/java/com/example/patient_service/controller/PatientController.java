package com.example.paitient_service.controller;

import com.example.paitient_service.dto.PaitientResponseDTO;
import com.example.paitient_service.service.PaitientService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/patients")
@RequiredArgsConstructor
public class PaitientController {
    private final PaitientService paitientService;

    @GetMapping
    public ResponseEntity<List<PaitientResponseDTO>> getPatients(){
        List<PaitientResponseDTO> paitientResponseDTOS = paitientService.getPatients();

        return ResponseEntity.ok().body(paitientResponseDTOS);
    }


}
