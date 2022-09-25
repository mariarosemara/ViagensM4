package model;

public class Empresa {
	private String id;
	private String cnpj;
	private String localidade;
	private String proprietario;
	private String login;
    private String senha;
    
	public Empresa() {
		super();
	}
	
	public Empresa(String id, String cnpj, String localidade, String proprietario, String login, String senha) {
		super();
		this.id = id;
		this.cnpj = cnpj;
		this.localidade = localidade;
		this.proprietario = proprietario;
		this.login = login;
		this.senha = senha;
	}


	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
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
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
    
 }