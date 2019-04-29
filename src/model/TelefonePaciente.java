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

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Long getIdtelefonepaciente() {
		return idtelefonepaciente;
	}

}
