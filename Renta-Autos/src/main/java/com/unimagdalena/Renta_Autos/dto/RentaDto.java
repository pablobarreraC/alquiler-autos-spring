package com.unimagdalena.Renta_Autos.dto;

import java.time.LocalDate;

public record RentaDto(Long id,
                       String fechaInicio, //pasar en formato yyyy-mm-dd (ISO 8601)
                       String fechaFinal, //pasar en formato yyyy-mm-dd (ISO 8601)
                       Double total) {}
