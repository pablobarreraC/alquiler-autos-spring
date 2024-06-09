package com.unimagdalena.Renta_Autos.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "rentas")
public class Renta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Temporal(TemporalType.DATE)
    private LocalDate fechaInicio;
    @Temporal(TemporalType.DATE)
    private LocalDate fechaFinal;
    private Double total;

    //auto de la renta
    @ManyToOne
    @JoinColumn(name = "auto_id")
    @JsonBackReference
    private Auto auto;

    //cliente de la renta
    @ManyToOne
    @JoinColumn(name = "renta_id")
    @JsonBackReference
    private Cliente cliente;
}
