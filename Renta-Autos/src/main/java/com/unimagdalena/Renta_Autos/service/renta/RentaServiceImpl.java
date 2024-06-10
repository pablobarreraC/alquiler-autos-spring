package com.unimagdalena.Renta_Autos.service.renta;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unimagdalena.Renta_Autos.dto.RentaDto;
import com.unimagdalena.Renta_Autos.dto.RentaToSaveDto;
import com.unimagdalena.Renta_Autos.dto.mapper.RentaMapper;
import com.unimagdalena.Renta_Autos.entities.Cliente;
import com.unimagdalena.Renta_Autos.entities.Renta;

import com.unimagdalena.Renta_Autos.repository.RentaRepository;
import com.unimagdalena.exception.NotAbleToDeleteException;
import com.unimagdalena.exception.NotFoundExceptionEntity;

@Service
public class RentaServiceImpl implements RentaService{

    private final RentaRepository rentaRepository;
    private final RentaMapper rentaMapper;

    @Autowired
    public RentaServiceImpl(RentaRepository rentaRepository, RentaMapper rentaMapper) {
        this.rentaRepository = rentaRepository;
        this.rentaMapper = rentaMapper;
    }

    @Override
    public RentaDto getRentaById(Long id) throws NotFoundExceptionEntity {
         Renta renta = rentaRepository.findById(id)
        .orElseThrow(() -> new NotFoundExceptionEntity("la renta solicitada no pudo ser encontrado, verificar que el id si exista."));
        return rentaMapper.entityToDto(renta);
    }

    @Override
    public RentaDto agregarRenta(RentaToSaveDto rentaToSaveDto) {
        Renta renta = rentaMapper.toSaveDtoToEntity(rentaToSaveDto);
        return rentaMapper.entityToDto(rentaRepository.save(renta));
    }

    @Override
    public RentaDto actualizarRenta(Long id, RentaToSaveDto rentaToSaveDto) throws NotFoundExceptionEntity {
        Renta rentaInDb = rentaRepository.findById(id)
        .orElseThrow(() -> new NotFoundExceptionEntity("La renta no pudo ser actualizado, verificar que el id si exista."));
         //  rentaInDb.setAuto(rentaToSaveDto.idAuto());
         //  rentaInDb.setCliente(rentaToSaveDto.idCliente());
         //  rentaInDb.setFechaFinal(rentaToSaveDto.fechaFinal());
         //  rentaInDb.setFechaInicio(rentaToSaveDto.fechaInicio());
         //  rentaInDb.setTotal(rentaToSaveDto.total());
        
        Renta rentaGuardada = rentaRepository.save(rentaInDb);
        
        return rentaMapper.entityToDto(rentaGuardada);
    }

    @Override
    public void eliminarRenta(Long id) {
         Renta rentaEliminar = rentaRepository.findById(id)
                .orElseThrow(() -> new NotAbleToDeleteException("La renta a eliminar no pudo ser encontrado, verificar que el id si exista."));
        rentaRepository.delete(rentaEliminar);
    }

    @Override
    public List<RentaDto> getAllRents() {
        List<Renta> rentas = rentaRepository.findAll();
        return rentas.stream()
                .map(renta -> rentaMapper.entityToDto(renta))
                .toList();
    }

}
