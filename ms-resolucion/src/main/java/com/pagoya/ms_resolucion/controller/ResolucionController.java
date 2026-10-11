package com.pagoya.ms_resolucion.controller;

import com.pagoya.ms_resolucion.dto.ResolucionRequestDTO;
import com.pagoya.ms_resolucion.service.ResolucionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/resoluciones")
@RequiredArgsConstructor
public class ResolucionController {

    private final ResolucionService resolucionService;

    @PostMapping
    public ResponseEntity<Map<String, Object>> resolverReclamo(@RequestBody ResolucionRequestDTO request) {
        Map<String, Object> resultado = resolucionService.procesarResolucion(request);

        if ("exito".equals(resultado.get("status"))) {
            return ResponseEntity.ok(resultado);
        } else if (resultado.get("mensaje").toString().contains("No existe")) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(resultado);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(resultado);
        }
    }
}