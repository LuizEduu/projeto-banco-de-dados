package model;

public class TelefoneHospital {

	private long idhospital;
	private String numerotelefone;

	public TelefoneHospital() {
	}

	public TelefoneHospital(String numerotelefone) {
		this.numerotelefone = numerotelefone;
	}

	public long getIdhospital() {
		return idhospital;
	}

	public void setIdhospital(long idhospital) {
		this.idhospital = idhospital;
	}

	public String getNumerotelefone() {
		return numerotelefone;
	}

	public void setNumerotelefone(String numerotelefone) {
		this.numerotelefone = numerotelefone;
	}

}
