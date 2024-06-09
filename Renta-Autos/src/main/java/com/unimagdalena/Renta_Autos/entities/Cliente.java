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
@Table(name = "clientes")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String apellido;
    private String cedula;
    private String direccion;
    private String telefono;

    //rentas que ha hecho el cliente
    @OneToMany(mappedBy = "cliente",fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<Renta> rentas;
}
