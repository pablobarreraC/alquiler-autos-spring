package com.unimagdalena.Renta_Autos.dto.mapper;

import com.unimagdalena.Renta_Autos.dto.RentaDto;
import com.unimagdalena.Renta_Autos.entities.Renta;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import javax.crypto.spec.PSource;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface RentaMapper {
    RentaMapper instancia= Mappers.getMapper(RentaMapper.class);
    @Mapping(source = "fechaInicio",target = "fechaInicio",qualifiedByName = "dateToString")
    @Mapping(source = "fechaFinal",target = "fechaFinal",qualifiedByName = "dateToString")
    RentaDto entityToDto(Renta renta);

    @Mapping(source = "fechaInicio",target = "fechaInicio",qualifiedByName = "stringToDate")
    @Mapping(source = "fechaFinal",target = "fechaFinal",qualifiedByName = "stringToDate")
    Renta toSaveDtoToEntity();

    @Named("dateToString")
    static String dateToString(LocalDate fechaDate){
        return fechaDate.format(DateTimeFormatter.ISO_LOCAL_DATE);
    }

    @Named("stringToDate")
    static LocalDate stringToDate(String fecha){
        return LocalDate.parse(fecha,DateTimeFormatter.ISO_LOCAL_DATE);
    }
}
