package br.com.alesil.datafoot.ctrl;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name="scoutEx")
@ViewScoped
public class Scout {
	public List<Posicoes> pos = new ArrayList<Posicoes>();

	public Scout(){

		
	}

	public List<Posicoes> getPos() {
		
		Posicoes posicao = new Posicoes();
		posicao.setPosicao("p1");
		posicao.setVisivel(true);
		
		Posicoes posicao2 = new Posicoes();
		posicao2.setPosicao("p2");
		posicao2.setVisivel(false);
		
		Posicoes posicao3 = new Posicoes();
		posicao3.setPosicao("p3");
		posicao3.setVisivel(true);
		
		Posicoes posicao4 = new Posicoes();
		posicao4.setPosicao("p4");
		posicao4.setVisivel(false);
		
		Posicoes posicao5 = new Posicoes();
		posicao5.setPosicao("p5");
		posicao5.setVisivel(false);
		
		Posicoes posicao6 = new Posicoes();
		posicao6.setPosicao("p6");
		posicao6.setVisivel(true);

		pos.add(posicao);
		pos.add(posicao2);
		pos.add(posicao3);
		pos.add(posicao4);
		pos.add(posicao5);
		pos.add(posicao6);
		
		return pos;
	}

	public void setPos(List<Posicoes> pos) {
		this.pos = pos;
	}

	
}
