package br.com.alesil.datafoot.converters;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import br.com.alesil.datafoot.dao.AtletaDao;
import br.com.alesil.datafoot.model.Atleta;

@FacesConverter("atletaConverter")
public class AtletaConverter implements Converter{

public static List<Atleta> lstAtleta;
	
	static {  
		lstAtleta = new ArrayList<Atleta>();
		lstAtleta = new AtletaDao().listarAtletas();
         
    }  
	
	@Override
	public Object getAsObject(FacesContext facesContext, UIComponent component, String submittedValue) {
		 if (submittedValue.trim().equals("")) {  
	            return null;  
	        } else {  
	            try {  
	            	
	                for (Atleta atleta : lstAtleta) {  
	                    if (atleta.getGuidAtleta().equals(submittedValue)) {  
	                        return atleta.getGuidAtleta();  
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
