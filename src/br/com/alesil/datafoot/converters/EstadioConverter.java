package br.com.alesil.datafoot.converters;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import br.com.alesil.datafoot.dao.EstadioDao;
import br.com.alesil.datafoot.model.Estadio;

@FacesConverter("estadioConverter")
public class EstadioConverter implements Converter {

public static List<Estadio> lstEstadio;
	
	static {  
		lstEstadio = new ArrayList<Estadio>();
		lstEstadio = new EstadioDao().listaEstadio();
         
    }  
	
	@Override
	public Object getAsObject(FacesContext facesContext, UIComponent component, String submittedValue) {
		 if (submittedValue.trim().equals("")) {  
	            return null;  
	        } else {  
	            try {  
	            	
	                for (Estadio estadio : lstEstadio) {  
	                    if (estadio.getGuidEstadio().equals(submittedValue)) {  
	                        return estadio.getGuidEstadio();  
	                    }  
	                }  
	  
	            } catch(NumberFormatException exception) {  
	                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid player"));  
	            }  
	        }  
	  
	        return null;  
	    }  


	@Override
	public String getAsString(FacesContext facesContext, UIComponent component, Object value) {
		if (value == null || value.equals("")) {  
            return "";  
        } else {  
            return (String)value;  
        }  
    }  

}
