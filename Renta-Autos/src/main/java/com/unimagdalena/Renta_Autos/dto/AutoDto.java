package com.unimagdalena.Renta_Autos.dto;

import java.util.List;

public record AutoDto(Long id,
                      String modelo,
                      String ciudad,
                      String imagenUrl,
                      Double precio,
                      List<RentaDto> rentas) {}
