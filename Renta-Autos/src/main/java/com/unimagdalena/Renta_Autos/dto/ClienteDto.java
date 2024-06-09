package com.unimagdalena.Renta_Autos.dto;

public record ClienteDto(Long id,
                         String nombre,
                         String apellido,
                         String cedula,
                         String direccion,
                         String telefono) {}
