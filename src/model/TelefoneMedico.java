package model;

public class TelefoneMedico {

	private long id;
	private String numero;

	public TelefoneMedico() {
	}

	public TelefoneMedico(String numero) {
		super();
		this.numero = numero;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

}
