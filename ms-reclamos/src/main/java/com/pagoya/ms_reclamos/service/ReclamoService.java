package com.pagoya.ms_reclamos.service;

import com.pagoya.ms_reclamos.dto.ReclamoActualizarDTO;
import com.pagoya.ms_reclamos.dto.ReclamoRequestDTO;
import com.pagoya.ms_reclamos.entity.Reclamo;
import com.pagoya.ms_reclamos.repository.ReclamoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReclamoService {

    private final ReclamoRepository reclamoRepository;

    public Reclamo registrarReclamo(ReclamoRequestDTO request) {
        Reclamo reclamo = Reclamo.builder()
                .fechareclamo(LocalDateTime.now())
                .nomcliente(request.getNomcliente())
                .ultimos4tarjeta(request.getUltimos4tarjeta())
                .motivo(request.getMotivo())
                .nomAnalista("No asignado")
                .estado(1)
                .observacion("por evaluar")
                .build();

        return reclamoRepository.save(reclamo);
    }

    public Optional<Reclamo> buscarPorNumero(Long numreclamo) {
        return reclamoRepository.findById(numreclamo);
    }

    public Optional<Reclamo> actualizarReclamo(Long numreclamo, ReclamoActualizarDTO dto) {
        return reclamoRepository.findById(numreclamo).map(reclamo -> {
            if (dto.getEstado() != null) {
                reclamo.setEstado(dto.getEstado());
            }
            if (dto.getNomAnalista() != null) {
                reclamo.setNomAnalista(dto.getNomAnalista());
            }
            if (dto.getObservacion() != null) {
                reclamo.setObservacion(dto.getObservacion());
            }
            return reclamoRepository.save(reclamo);
        });
    }
}