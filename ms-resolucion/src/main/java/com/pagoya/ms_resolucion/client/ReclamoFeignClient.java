package com.pagoya.ms_resolucion.client;

import com.pagoya.ms_resolucion.dto.ReclamoActualizarDTO;
import com.pagoya.ms_resolucion.dto.ReclamoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "ms-reclamos")
public interface ReclamoFeignClient {

    @GetMapping("/api/reclamos/{numreclamo}")
    ReclamoDTO consultarPorNumero(@PathVariable("numreclamo") Long numreclamo);

    @PutMapping("/api/reclamos/{numreclamo}")
    ReclamoDTO actualizarReclamo(@PathVariable("numreclamo") Long numreclamo, @RequestBody ReclamoActualizarDTO request);
}