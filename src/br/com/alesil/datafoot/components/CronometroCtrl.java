package br.com.alesil.datafoot.components;

import java.io.Serializable;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.joda.time.LocalTime;
import org.joda.time.Period;

@ManagedBean(name="cronometroCtrl")
@ViewScoped
public class CronometroCtrl implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static String TEMPO_AUXILIAR;
	
	private LocalTime inicio;
	private LocalTime fim;

	private String tempo;
	private String tempoJogo = "1";
	private boolean emExecucao = true;
	
	Period period;
	
	int minPausa = 0;
	int segPausa = 0;

	public CronometroCtrl (){
		
	}


	public void iniciarPoll()
    {
		if(inicio == null){
			inicio = new LocalTime(new Date()); 
		}
    }
	
	public void pararPoll(){
		this.emExecucao = false;
		fim = new LocalTime(new Date());
		inicio = fim;
		
		minPausa = period.getMinutes();
		segPausa = period.getSeconds();

    }
	
	public void recomecarPoll(){
		this.emExecucao = true;

	}

    public void cronometro()
    { 
    	fim = new LocalTime(new Date());    

    	period = new Period(inicio, fim);  
  
    	tempo = String.valueOf(period.getMinutes())
    			.concat(":")
    			.concat(String.valueOf(period.getSeconds()));
    	TEMPO_AUXILIAR = tempo;
    }
	public String getTempoJogo() {
		return tempoJogo;
	}
	public void setTempoJogo(String tempoJogo) {
		this.tempoJogo = tempoJogo;
	}
	public boolean isEmExecucao() {
		return emExecucao;
	}
	public void setEmExecucao(boolean pausado) {
		this.emExecucao = pausado;
	}

	public String getTempo() {
		return tempo;
	}

	public void setTempo(String tempo) {
		this.tempo = tempo;
	}
}
