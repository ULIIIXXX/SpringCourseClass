package com.bolsadeideas.springboot.di.restaurant;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.bolsadeideas.springboot.di.restaurant.models.ItemOrden;
import com.bolsadeideas.springboot.di.restaurant.models.Orden;

@Configuration
public class AppConfig {
	@Primary
	@Bean("misOrdenes")
	public List<ItemOrden> registarOrdenes(){
		Orden mesa1 = new Orden("Langosta 2kg",3500.00);
		Orden mesa2 = new Orden("Camarones empamizados", 350.00);
		Orden mesa3 = new Orden("Mojarra al mojo de ajo", 255.50);
		
		ItemOrden linea1 = new ItemOrden(mesa1 , 1);
		ItemOrden linea2 = new ItemOrden(mesa2, 1);
		ItemOrden linea3 = new ItemOrden(mesa3 , 1);
		
		return Arrays.asList(linea1, linea2, linea3);
	}
}
