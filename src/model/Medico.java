package model;

public class Medico {

	private Long id;
	private String nome;
	private String sexo;
	private String especialidade;

	public Medico() {
	}

	public Medico(String nome, String sexo, String especialidade) {
		super();
		this.nome = nome;
		this.sexo = sexo;
		this.especialidade = especialidade;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}

}
