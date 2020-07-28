package com.bolsadeideas.springboot.form.editors;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bolsadeideas.springboot.form.services.PaisService;

@Component
public class PaisPropertyEditoy  extends PropertyEditorSupport{

	@Autowired
	private PaisService paisService;
	
	@Override
	public void setAsText(String idString) throws IllegalArgumentException {
		if(idString != null && idString.length() > 0) {
			try {
				int id = Integer.parseInt(idString);
				this.setValue(paisService.findPaisById(id));
			}catch(NumberFormatException ex) {
				setValue(null);
			}
			
		}else {
			setValue(null);
		}
		
	}
	
	
}
