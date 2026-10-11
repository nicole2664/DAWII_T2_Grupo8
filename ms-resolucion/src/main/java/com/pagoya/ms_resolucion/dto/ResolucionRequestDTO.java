package com.pagoya.ms_resolucion.dto;

import lombok.Data;

@Data
public class ResolucionRequestDTO {
    private Long numreclamo;
    private Integer estado;
    private String nomAnalista;
    private String observacion;
}