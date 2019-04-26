package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "paciente")
public class Paciente implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	@Column(name = "idpaciente")
	private int id;
	private String nome;
	private String sexo;
	private String email;
	private String nascimento;

	public Paciente() {
	}

	public Paciente(String nome, String sexo, String email, String nascimento) {
		this.nome = nome;
		this.sexo = sexo;
		this.email = email;
		this.nascimento = nascimento;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

}
