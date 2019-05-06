package model;

public class Consulta {

	private long idconsulta;
	private String dataconsulta;
	private String diagnostico;
	private String id_paciente;
	private String id_hospital;
	private String id_medico;

	public Consulta() {
	}

	public Consulta(String dataconsulta, String diagnostico, String id_paciente, String id_medico, String id_hospital) {
		this.dataconsulta = dataconsulta;
		this.diagnostico = diagnostico;
		this.id_paciente = id_paciente;
		this.id_hospital = id_hospital;
		this.id_medico = id_medico;
	}

	public long getIdconsulta() {
		return idconsulta;
	}

	public void setIdconsulta(long idconsulta) {
		this.idconsulta = idconsulta;
	}

	public String getDataconsulta() {
		return dataconsulta;
	}

	public void setDataconsulta(String dataconsulta) {
		this.dataconsulta = dataconsulta;
	}

	public String getDiagnostico() {
		return diagnostico;
	}

	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}

	public String getId_paciente() {
		return id_paciente;
	}

	public void setId_paciente(String id_paciente) {
		this.id_paciente = id_paciente;
	}

	public String getId_hospital() {
		return id_hospital;
	}

	public void setId_hospital(String id_hospital) {
		this.id_hospital = id_hospital;
	}

	public String getId_medico() {
		return id_medico;
	}

	public void setId_medico(String id_medico) {
		this.id_medico = id_medico;
	}

}
