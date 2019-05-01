package model;

public class Hospital {

	private long idhospital;
	private String nome;
	private String cnpj;
	private String rua;
	private String bairro;
	private String cidade;
	private TelefoneHospital telefoneHospital;

	public Hospital() {
	}

	public Hospital(long idhospital, String nome, String cnpj, String rua, String bairro, String cidade) {
		this.nome = nome;
		this.cnpj = cnpj;
		this.rua = rua;
		this.bairro = bairro;
		this.cidade = cidade;
	}

	public long getIdhospital() {
		return idhospital;
	}

	public void setIdhospital(long idhospital) {
		this.idhospital = idhospital;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public TelefoneHospital getTelefoneHospital() {
		return telefoneHospital;
	}

	public void setTelefoneHospital(TelefoneHospital telefoneHospital) {
		this.telefoneHospital = telefoneHospital;
	}
}
