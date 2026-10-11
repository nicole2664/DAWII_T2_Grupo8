package com.pagoya.ms_resolucion.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class ReclamoDTO {
    private Long numreclamo;
    private LocalDateTime fechareclamo;
    private String nomcliente;
    private String ultimos4tarjeta;
    private String motivo;
    private String nomAnalista;
    private Integer estado;
    private String observacion;
}