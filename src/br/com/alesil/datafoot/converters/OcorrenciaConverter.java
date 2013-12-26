package br.com.alesil.datafoot.converters;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import br.com.alesil.datafoot.dao.ScoutAcaoDao;
import br.com.alesil.datafoot.model.ScoutAcao;

@FacesConverter("ocorrenciaConverter")
public class OcorrenciaConverter implements Converter {

public static List<ScoutAcao> lstAcoes;
	
	static {  
		lstAcoes = new ArrayList<ScoutAcao>();
		lstAcoes = new ScoutAcaoDao().listaOperacoes();
    } 
	
	@Override
	public Object getAsObject(FacesContext facesContext, UIComponent component, String submittedValue) {
		 if (submittedValue.trim().equals("")) {  
	            return null;  
	        } else {  
	            try {  
	            	
	                for (ScoutAcao acao : lstAcoes) {  
	                    if (acao.getDescricao().equals(submittedValue)) {  
	                        return acao.getGuidAcao();  
	                    }  
	                }  
	  
	            } catch(NumberFormatException exception) {  
	                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid player"));  
	            }  
	        }  
	  
	        return null;  
	    }  
	

	@Override
	public String getAsString(FacesContext facescontext, UIComponent component, Object value) {
		if (value == null || value.equals("")) {  
            return "";  
        } else {  
            return ((ScoutAcao)value).getDescricao();  
        }  
	}

}
