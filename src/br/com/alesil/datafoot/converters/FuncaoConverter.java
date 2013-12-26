package br.com.alesil.datafoot.converters;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import br.com.alesil.datafoot.dao.FuncaoComissaoTecnicaDao;
import br.com.alesil.datafoot.model.FuncaoComissaoTecnica;

@FacesConverter("funcaoConverter")
public class FuncaoConverter implements Converter{
	public static List<FuncaoComissaoTecnica> lstFuncao;
	static {  
		lstFuncao = new ArrayList<FuncaoComissaoTecnica>();
		lstFuncao = new FuncaoComissaoTecnicaDao().listaFuncoes();
    }  
	
	@Override
	public Object getAsObject(FacesContext facesContext, UIComponent component, String submittedValue) {
		 if (submittedValue.trim().equals("")) {  
	            return null;  
	        } else {  
	            try {  
	            	
	                for (FuncaoComissaoTecnica funcao : lstFuncao) {  
	                    if (funcao.getGuidFuncao().equals(submittedValue)) { 
	                    	try{
	                    		System.out.print(funcao.getNomeFuncao());
	                    	return funcao;  
	                    	}catch(Exception e){
	                    		System.out.print(e.toString());
	                    	}
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
