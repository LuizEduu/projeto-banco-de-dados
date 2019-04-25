package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "enderecopaciente")
public class EnderecoPaciente {

	@Id
	@GeneratedValue
	@Column(name = "idenderecopaciente")
	private int idenderecopaciente;
	private String rua;
	private String numero;
	private String bairro;
	private String cidade;

	public EnderecoPaciente(String rua, String numero, String bairro, String cidade) {
		super();
		this.rua = rua;
		this.numero = numero;
		this.bairro = bairro;
		this.cidade = cidade;
	}

	public int getIdenderecopaciente() {
		return idenderecopaciente;
	}

	public void setIdenderecopaciente(int idenderecopaciente) {
		this.idenderecopaciente = idenderecopaciente;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
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

}