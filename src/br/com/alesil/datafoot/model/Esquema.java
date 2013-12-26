package br.com.alesil.datafoot.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="df_esquema")
public class Esquema implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="ESQ_GUID_ESQUEMA")
	private String guidesquema;
	
	@Column(name="ESQ_ESQUEMA")
	private String esquema;
	
	@Column(name="ESQ_A1")
	private String a1;
	
	@Column(name="ESQ_B1")
	private String b1; 
	
	@Column(name="ESQ_C1")
	private String c1; 
	
	@Column(name="ESQ_A2")
	private String a2; 
	
	@Column(name="ESQ_B2")
	private String b2; 
	
	@Column(name="ESQ_C2")
	private String c2; 
	
	@Column(name="ESQ_A3")
	private String a3; 
	
	@Column(name="ESQ_B3")
	private String b3; 
	
	@Column(name="ESQ_C3")
	private String c3; 
	
	@Column(name="ESQ_D3")
	private String d3; 
	
	@Column(name="ESQ_E3")
	private String e3; 
	
	@Column(name="ESQ_A4")
	private String a4; 
	
	@Column(name="ESQ_B4")
	private String b4; 
	
	@Column(name="ESQ_C4")
	private String c4;  
	
	@Column(name="ESQ_A5")
	private String a5; 
	
	@Column(name="ESQ_B5")
	private String b5; 
	
	@Column(name="ESQ_C5")
	private String c5;  
	
	@Column(name="ESQ_A6")
	private String a6;
	
	@Column(name="ESQ_B6")
	private String b6; 
	
	@Column(name="ESQ_C6")
	private String c6;
		
	public String getGuidesquema() {
		return guidesquema;
	}
	public void setGuidesquema(String guidesquema) {
		this.guidesquema = guidesquema;
	}
	public String getEsquema() {
		return esquema;
	}
	public void setEsquema(String esquema) {
		this.esquema = esquema;
	}
	public String getA1() {
		return a1;
	}
	public void setA1(String a1) {
		this.a1 = a1;
	}
	public String getB1() {
		return b1;
	}
	public void setB1(String b1) {
		this.b1 = b1;
	}
	public String getC1() {
		return c1;
	}
	public void setC1(String c1) {
		this.c1 = c1;
	}
	public String getA2() {
		return a2;
	}
	public void setA2(String a2) {
		this.a2 = a2;
	}
	public String getB2() {
		return b2;
	}
	public void setB2(String b2) {
		this.b2 = b2;
	}
	public String getC2() {
		return c2;
	}
	public void setC2(String c2) {
		this.c2 = c2;
	}
	public String getA3() {
		return a3;
	}
	public void setA3(String a3) {
		this.a3 = a3;
	}
	public String getB3() {
		return b3;
	}
	public void setB3(String b3) {
		this.b3 = b3;
	}
	public String getC3() {
		return c3;
	}
	public void setC3(String c3) {
		this.c3 = c3;
	}
	public String getD3() {
		return d3;
	}
	public void setD3(String d3) {
		this.d3 = d3;
	}
	public String getE3() {
		return e3;
	}
	public void setE3(String e3) {
		this.e3 = e3;
	}
	public String getA4() {
		return a4;
	}
	public void setA4(String a4) {
		this.a4 = a4;
	}
	public String getB4() {
		return b4;
	}
	public void setB4(String b4) {
		this.b4 = b4;
	}
	public String getC4() {
		return c4;
	}
	public void setC4(String c4) {
		this.c4 = c4;
	}
	public String getA5() {
		return a5;
	}
	public void setA5(String a5) {
		this.a5 = a5;
	}
	public String getB5() {
		return b5;
	}
	public void setB5(String b5) {
		this.b5 = b5;
	}
	public String getC5() {
		return c5;
	}
	public void setC5(String c5) {
		this.c5 = c5;
	}
	public String getA6() {
		return a6;
	}
	public void setA6(String a6) {
		this.a6 = a6;
	}
	public String getB6() {
		return b6;
	}
	public void setB6(String b6) {
		this.b6 = b6;
	}
	public String getC6() {
		return c6;
	}
	public void setC6(String c6) {
		this.c6 = c6;
	}
	
	
}
