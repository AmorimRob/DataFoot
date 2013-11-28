package br.com.alesil.datafoot.servlet;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.apache.myfaces.custom.fileupload.UploadedFile;

@ManagedBean(name="imageCtrl")
@SessionScoped
public class ImageAux {	
	public static UploadedFile novaImagem;

}
