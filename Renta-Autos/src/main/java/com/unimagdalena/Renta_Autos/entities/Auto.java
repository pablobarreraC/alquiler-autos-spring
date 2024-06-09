package com.unimagdalena.Renta_Autos.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "autos")
public class Auto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String modelo;
    private String ciudad;
    private String imagenUrl;
    private Double precio;

    //rentas que tiene el auto
    @OneToMany(mappedBy = "auto",fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<Renta> rentas;
}
