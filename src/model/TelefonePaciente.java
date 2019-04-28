package model;

import java.io.Serializable;

public class TelefonePaciente implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long idtelefonepaciente;
	private String numero;

	
	public TelefonePaciente() {
	}

	public TelefonePaciente(String numero) {
		this.numero = numero;
	}

	public Long getIdtelefone() {
		return idtelefonepaciente;
	}

	public void setIdtelefone(Long idtelefone) {
		this.idtelefonepaciente = idtelefone;
	}

	public String getTelefone() {
		return numero;
	}

	public void setTelefone(String numero) {
		this.numero = numero;
	}

}
