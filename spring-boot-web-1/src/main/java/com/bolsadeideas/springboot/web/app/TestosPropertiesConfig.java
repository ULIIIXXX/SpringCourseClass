package com.bolsadeideas.springboot.web.app;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

//Para configurar la entrada de datos desde un archivo .properties que no necesariamente es el application.properties
@Configuration   //Indica la configuracion para la aplicacion web 
@PropertySources({
	@PropertySource("classpath:textos.properties")
	//Podemos tener mas separados por comas @PropertySource("classpath:textos.properites"),
})
public class TestosPropertiesConfig {

}
