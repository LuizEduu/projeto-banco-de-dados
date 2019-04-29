package model;

import java.io.Serializable;

public class Paciente implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String nome;
	private String cpf;
	private String sexo;
	private String email;
	private String nascimento;
	private TelefonePaciente telefonePaciente;
	private EnderecoPaciente enderecoPaciente;

	public Paciente() {
	}

	public Paciente(String nome, String cpf, String sexo, String email, String nascimento) {
		this.nome = nome;
		this.cpf = cpf;
		this.sexo = sexo;
		this.email = email;
		this.nascimento = nascimento;
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
	
	

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNascimento() {
		return nascimento;
	}

	public void setNascimento(String nascimento) {
		this.nascimento = nascimento;
	}

	@Override
	public String toString() {
		return "Paciente [id=" + id + ", nome=" + nome + ", sexo=" + sexo + ", email=" + email + ", nascimento="
				+ nascimento + "]";
	}

	public TelefonePaciente getTelefonePaciente() {
		return telefonePaciente;
	}

	public void setTelefonePaciente(TelefonePaciente telefonePaciente) {
		this.telefonePaciente = telefonePaciente;
	}

	public EnderecoPaciente getEnderecoPaciente() {
		return enderecoPaciente;
	}

	public void setEnderecoPaciente(EnderecoPaciente enderecoPaciente) {
		this.enderecoPaciente = enderecoPaciente;
	}

}
