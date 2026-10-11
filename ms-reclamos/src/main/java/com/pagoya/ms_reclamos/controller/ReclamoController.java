package com.pagoya.ms_reclamos.controller;

import com.pagoya.ms_reclamos.dto.ReclamoActualizarDTO;
import com.pagoya.ms_reclamos.dto.ReclamoRequestDTO;
import com.pagoya.ms_reclamos.entity.Reclamo;
import com.pagoya.ms_reclamos.service.ReclamoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/reclamos")
@RequiredArgsConstructor
public class ReclamoController {

    private final ReclamoService reclamoService;

    @PostMapping
    public ResponseEntity<Reclamo> registrar(@RequestBody ReclamoRequestDTO request) {
        Reclamo nuevoReclamo = reclamoService.registrarReclamo(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoReclamo);
    }

    @GetMapping("/{numreclamo}")
    public ResponseEntity<Reclamo> consultarPorNumero(@PathVariable Long numreclamo) {
        return reclamoService.buscarPorNumero(numreclamo)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{numreclamo}")
    public ResponseEntity<Reclamo> actualizar(
            @PathVariable Long numreclamo,
            @RequestBody ReclamoActualizarDTO request) {
        return reclamoService.actualizarReclamo(numreclamo, request)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}