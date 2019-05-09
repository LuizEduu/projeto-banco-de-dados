package model;

public class Consulta {

	private long idconsulta;
	private String dataconsulta;
	private String diagnostico;
	private long id_paciente;
	private long id_hospital;
	private long id_medico;
	private Paciente paciente = new Paciente();
	private Hospital hospita = new Hospital();
	private Medico medico = new Medico();

	public Consulta() {
	}

	public Consulta(String diagnostico, String dataconsulta, long id_paciente, long id_medico, long id_hospital) {
		this.diagnostico = diagnostico;
		this.dataconsulta = dataconsulta;
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

	public long getId_paciente() {
		return id_paciente;
	}

	public void setId_paciente(long id_paciente) {
		this.id_paciente = id_paciente;
	}

	public long getId_hospital() {
		return id_hospital;
	}

	public void setId_hospital(long id_hospital) {
		this.id_hospital = id_hospital;
	}

	public long getId_medico() {
		return id_medico;
	}

	public void setId_medico(long id_medico) {
		this.id_medico = id_medico;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Hospital getHospita() {
		return hospita;
	}

	public void setHospita(Hospital hospita) {
		this.hospita = hospita;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

}
