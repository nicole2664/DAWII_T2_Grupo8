package com.pagoya.ms_reclamos.dto;

import lombok.Data;

@Data
public class ReclamoActualizarDTO {
    private Integer estado;
    private String nomAnalista;
    private String observacion;
}