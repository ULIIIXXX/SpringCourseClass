package com.bolsadeideas.springboot.form.editors;

import java.beans.PropertyEditorSupport;

public class NombreMayusculasEditor extends PropertyEditorSupport  {

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		//Por defecto convierte todos los campos de tipo String 
		setValue(text.toUpperCase().trim());
	}
	
}
