package com.bolsadeideas.springboot.di.app;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.bolsadeideas.springboot.di.app.models.domain.ItemFactura;
import com.bolsadeideas.springboot.di.app.models.domain.Producto;
import com.bolsadeideas.springboot.di.app.models.service.IService;
import com.bolsadeideas.springboot.di.app.models.service.MiServicio;
import com.bolsadeideas.springboot.di.app.models.service.MiServicioComplejo;

//Me aorece una buena practica de programación definir aqui los bean o componentes del servicio web

@Configuration //Define la configuración de la aplicación
public class AppConfig {
	
	@Bean("miServicioSimple") //Notación con la que se definen los componentes o bien la @Component its the same 
	public IService servicioSimple() {
		return new  MiServicio();  //Esatmos creando la instancia de la clase
	}
	
	@Bean("miServicioComplejo")
	@Primary
	public IService servicioComplejo() {
		return new MiServicioComplejo();
	}
	
	@Bean("itemFactura")
	public List<ItemFactura> registrarItems(){
		Producto prod1 = new Producto("Xbox one", 5600);
		Producto prod2 = new Producto("Pantalla Alexa", 4000);
		
		ItemFactura linea1 = new ItemFactura(prod1 , 1);
		ItemFactura linea2 = new ItemFactura(prod2 , 3);
		
		return Arrays.asList(linea1, linea2);
	}
	@Primary
	@Bean("OtrosItems")
	public List<ItemFactura> registrarItems2(){
		Producto prod1 = new Producto("Monitor Gamer Azus" , 12000);
		Producto prod2 = new Producto("Teclado mecanico",1150);
		Producto prod3 = new Producto("Silla de oficina", 8000);
		Producto prod4 = new Producto("Escritorio elegante", 7000);
		
		ItemFactura linea1 = new ItemFactura(prod1 , 1);
		ItemFactura linea2 = new ItemFactura(prod2 , 1);
		ItemFactura linea3 = new ItemFactura(prod3, 1);
		ItemFactura linea4 = new ItemFactura(prod4 , 1);
		
		return Arrays.asList(linea1, linea2, linea3, linea4);
	}
}
