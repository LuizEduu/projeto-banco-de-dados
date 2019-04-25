package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "telefonepaciente")
public class TelefonePaciente {

	@Id
	@GeneratedValue
	@Column(name = "idtelefonepaciente")
	private int idtelefonepaciente;
	@Column(name = "numerotelefone")
	private String numero;

	public TelefonePaciente(String numero) {
		this.numero = numero;
	}

	public int getIdtelefone() {
		return idtelefonepaciente;
	}

	public void setIdtelefone(int idtelefone) {
		this.idtelefonepaciente = idtelefone;
	}

	public String getTelefone() {
		return numero;
	}

	public void setTelefone(String numero) {
		this.numero = numero;
	}

}
