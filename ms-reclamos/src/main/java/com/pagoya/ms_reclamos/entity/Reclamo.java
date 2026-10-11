package com.pagoya.ms_reclamos.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "reclamos")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Reclamo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numreclamo;

    private LocalDateTime fechareclamo;

    private String nomcliente;

    private String ultimos4tarjeta;

    private String motivo;

    @Builder.Default
    @Column(name = "nom_analista")
    private String nomAnalista = "No asignado";

    @Builder.Default
    private Integer estado = 1;
    @Builder.Default
    private String observacion = "por evaluar";
}