package com.unimagdalena.Renta_Autos;

import org.springframework.boot.SpringApplication;

public class TestRentaAutosApplication {

	public static void main(String[] args) {
		SpringApplication.from(RentaAutosApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
