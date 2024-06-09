package com.unimagdalena.Renta_Autos.dto.mapper;

import com.unimagdalena.Renta_Autos.dto.ClienteDto;
import com.unimagdalena.Renta_Autos.dto.ClienteToSaveDto;
import com.unimagdalena.Renta_Autos.entities.Cliente;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ClienteMapper {
    ClienteMapper instancia= Mappers.getMapper(ClienteMapper.class);

    Cliente toSaveDtoToEntity(ClienteToSaveDto cliente);
    ClienteDto entityToDto(Cliente cliente);
}
