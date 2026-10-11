package com.pagoya.ms_resolucion.service;

import com.pagoya.ms_resolucion.client.ReclamoFeignClient;
import com.pagoya.ms_resolucion.dto.ReclamoActualizarDTO;
import com.pagoya.ms_resolucion.dto.ReclamoDTO;
import com.pagoya.ms_resolucion.dto.ResolucionRequestDTO;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ResolucionService {

    private final ReclamoFeignClient reclamoFeignClient;

    public Map<String, Object> procesarResolucion(ResolucionRequestDTO request) {
        Map<String, Object> respuesta = new HashMap<>();

        if (request.getEstado() == null || (request.getEstado() != 2 && request.getEstado() != 3)) {
            respuesta.put("status", "error");
            respuesta.put("mensaje", "El estado ingresado no es valido. Debe ser 2 (Procedente) o 3 (Improcedente).");
            return respuesta;
        }

        try {
            ReclamoDTO reclamoExistente = reclamoFeignClient.consultarPorNumero(request.getNumreclamo());

            String obsFinal = request.getObservacion();
            if (obsFinal == null || obsFinal.isBlank()) {
                obsFinal = (request.getEstado() == 2)
                        ? "Resolucion favorable: Reclamo procedente"
                        : "Resolucion desestimada: Reclamo improcedente";
            }

            ReclamoActualizarDTO actualizarDTO = ReclamoActualizarDTO.builder()
                    .estado(request.getEstado())
                    .nomAnalista(request.getNomAnalista())
                    .observacion(obsFinal)
                    .build();

            ReclamoDTO reclamoActualizado = reclamoFeignClient.actualizarReclamo(request.getNumreclamo(), actualizarDTO);

            respuesta.put("status", "exito");
            respuesta.put("mensaje", "El reclamo fue resuelto y actualizado satisfactoriamente en el area de riesgos.");
            respuesta.put("reclamo", reclamoActualizado);
            return respuesta;

        } catch (FeignException.NotFound ex) {
            respuesta.put("status", "error");
            respuesta.put("mensaje", "No existe ningun reclamo registrado con el numero: " + request.getNumreclamo());
            return respuesta;
        } catch (Exception ex) {
            respuesta.put("status", "error");
            respuesta.put("mensaje", "Error de comunicacion con el servicio de reclamos: " + ex.getMessage());
            return respuesta;
        }
    }
}