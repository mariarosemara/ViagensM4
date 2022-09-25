package model;

public class Destino {

	private String id;
	private String nome;
	private String valor;
	private String localidade;
	private String proprietario;

	
	public Destino() {
		super();
	}
	
	public Destino(String id, String nome, String valor, String localidade, String proprietario) {
		super();
		this.id = id;
		this.nome = nome;
		this.valor = valor;
		this.localidade = localidade;
		this.proprietario = proprietario;
	}


	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}
	public String getLocalidade() {
		return localidade;
	}
	public void setLocalidade(String localidade) {
		this.localidade = localidade;
	}
	public String getProprietario() {
		return proprietario;
	}
	public void setProprietario(String proprietario) {
		this.proprietario = proprietario;
	}

}
