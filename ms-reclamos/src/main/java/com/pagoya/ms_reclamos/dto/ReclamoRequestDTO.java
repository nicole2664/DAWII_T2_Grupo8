package com.pagoya.ms_reclamos.dto;

import lombok.Data;

@Data
public class ReclamoRequestDTO {
    private String nomcliente;
    private String ultimos4tarjeta;
    private String motivo;
}