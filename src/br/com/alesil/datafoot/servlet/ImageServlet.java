package br.com.alesil.datafoot.servlet;

import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.myfaces.custom.fileupload.UploadedFile;

import br.com.alesil.datafoot.dao.AtletaDao;
import br.com.alesil.datafoot.dao.ClubeDao;
import br.com.alesil.datafoot.dao.ComissaoTecnicaDao;
import br.com.alesil.datafoot.dao.CompeticaoDao;
import br.com.alesil.datafoot.dao.EstadioDao;

public class ImageServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final int DEFAULT_BUFFER_SIZE = 30240;

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		UploadedFile file = ImageAux.novaImagem;
		
		String imageId = request.getParameter("id");
		String imageTipo = request.getParameter("tipo");

		if (imageTipo.equals("temp")) {
			response.reset();
			response.setBufferSize(DEFAULT_BUFFER_SIZE);
			response.setContentType(file.getContentType());
			response.setContentLength((int) file.getSize());
			response.setHeader("Content-Disposition", "inline; filename=\"".concat(file.getName()).concat( "\""));

			BufferedOutputStream output = null;

			try {
				// Open streams.
				output = new BufferedOutputStream(response.getOutputStream(),
						DEFAULT_BUFFER_SIZE);

				// Write file contents to response.
				output.write(file.getBytes());
			} finally {
				// Gently close streams.
				ImageAux.novaImagem = null;
				close(output);
			}

		} else {
			byte[] arrayImagem = null;

			switch (imageTipo) {
				case "atleta":
					arrayImagem = new AtletaDao().buscarFoto(imageId);
					break;
					
				case "comissao":
					arrayImagem = new ComissaoTecnicaDao().buscarFoto(imageId);
					break;
					
				case "clube":
					arrayImagem = new ClubeDao().buscarFoto(imageId);
					break;
					
				case "competicao":
					arrayImagem = new CompeticaoDao().buscarFoto(imageId);
					//is = new ByteArrayInputStream(arrayImagem);
					break;
					
				case "estadio":
					arrayImagem = new EstadioDao().buscarFoto(imageId);
					break;
					
				default:
				//	URL url = this.getClass().getResource("/resources/imagens/alesil.png");
					//BufferedImage originalImage = 
                     //       ImageIO.read(new File(this.getClass().getResource("/resources/imagens/alesil.png"));
					// FileInputStream    is = new FileInputStream(url.getFile());
					//    arrayImagem = new byte[is.available()];
					 //   is.read(arrayImagem);
					  //  is.close();
					   
					arrayImagem = null;
		            
				}

			BufferedOutputStream output = null;

			try {
				// Open streams.
				output = new BufferedOutputStream(response.getOutputStream(),
						DEFAULT_BUFFER_SIZE);

				// Write file contents to response.
				output.write(arrayImagem);
			} finally {
				// Gently close streams.
				close(output);
			}
		} 
	}


	
	private static void close(Closeable resource) {
		if (resource != null) {
			try {
				resource.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
