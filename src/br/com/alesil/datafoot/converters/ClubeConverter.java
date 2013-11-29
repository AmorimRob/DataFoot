package br.com.alesil.datafoot.converters;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import br.com.alesil.datafoot.dao.ClubeDao;
import br.com.alesil.datafoot.model.Clube;

@FacesConverter("clubeConverter")
public class ClubeConverter implements Converter{

	public static List<Clube> lstClube;
	
	static {  
		lstClube = new ArrayList<Clube>();
		lstClube = new ClubeDao().comboClubes();
    }  
	
	@Override
	public Object getAsObject(FacesContext facesContext, UIComponent component, String submittedValue) {
		 if (submittedValue.trim().equals("")) {  
	            return null;  
	        } else {  
	            try {  
	            	
	                for (Clube clube : lstClube) {  
	                    if (clube.getGuidClube().equals(submittedValue)) {  
	                        return clube.getGuidClube();  
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
