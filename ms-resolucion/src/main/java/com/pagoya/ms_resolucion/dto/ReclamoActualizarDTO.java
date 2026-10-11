package com.pagoya.ms_resolucion.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ReclamoActualizarDTO {
    private Integer estado;
    private String nomAnalista;
    private String observacion;
}