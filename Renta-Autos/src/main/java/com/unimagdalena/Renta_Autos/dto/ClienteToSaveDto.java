package com.unimagdalena.Renta_Autos.dto;

public record ClienteToSaveDto(String nombre,
                               String apellido,
                               String cedula,
                               String direccion,
                               String telefono) {}
