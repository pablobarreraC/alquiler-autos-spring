package com.unimagdalena.Renta_Autos.dto.mapper;

import com.unimagdalena.Renta_Autos.dto.AutoDto;
import com.unimagdalena.Renta_Autos.dto.AutoToSaveDto;
import com.unimagdalena.Renta_Autos.dto.RentaDto;
import com.unimagdalena.Renta_Autos.entities.Auto;
import com.unimagdalena.Renta_Autos.entities.Renta;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface AutoMapper {
    AutoMapper instancia= Mappers.getMapper(AutoMapper.class);
    Auto toSaveDtoToEntity(AutoToSaveDto auto);
    @Mapping(source = "rentas",target = "rentas",qualifiedByName = "listEntityToDto")
    AutoDto entityToDto(Auto auto);

    @Named("listEntityToDto")
    static List<RentaDto> listEntityToDto(List<Renta> rentas){
        return rentas.stream().map(RentaMapper.instancia::entityToDto)
                .collect(Collectors.toList());
    }
}
