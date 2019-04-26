package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "telefonepaciente")
public class TelefonePaciente implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	@Column(name = "idtelefonepaciente")
	private int idtelefonepaciente;
	@Column(name = "numerotelefone")
	private String numero;

	// @Column(name = "id_paciente")
	@ManyToOne
	@GeneratedValue
	@JoinColumn(name = "id_paciente", referencedColumnName = "idpaciente")
	private Paciente idpaciente;

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
