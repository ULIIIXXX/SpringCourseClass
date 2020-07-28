package com.bolsadeideas.springboot.form.editors;

import java.beans.PropertyEditorSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.bolsadeideas.springboot.form.services.RoleService;

@Component
public class RoleEditor extends PropertyEditorSupport {
	
	@Autowired
	private RoleService roleService;
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		try {
			Integer id;
			id = Integer.parseInt(text);
			setValue(roleService.obtenerPorId(id));
		}catch(NumberFormatException ex) {
			setValue(null);
		}
	}

}
