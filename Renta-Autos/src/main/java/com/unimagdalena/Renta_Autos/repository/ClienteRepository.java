package com.unimagdalena.Renta_Autos.repository;

import com.unimagdalena.Renta_Autos.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente,Long> {}
