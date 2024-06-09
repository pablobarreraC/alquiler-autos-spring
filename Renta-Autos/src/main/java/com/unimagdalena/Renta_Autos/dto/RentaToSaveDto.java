package com.unimagdalena.Renta_Autos.dto;

public record RentaToSaveDto(String fechaInicio,
                             String fechaFinal,
                             Double total,
                             Long idAuto,
                             Long idCliente) {}
