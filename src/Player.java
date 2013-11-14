
public class Player {
	private String nome;
	private int numero;
	private String foto;
	private String posicao;
	
	public Player(String nome, int numero, String foto, String posicao){
		this.nome = nome;
		this.numero = numero;
		this.foto = foto;
		this.posicao = posicao;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
	public String getPosicao() {
		return posicao;
	}
	public void setPosicao(String posicao) {
		this.posicao = posicao;
	}
	
	
}
