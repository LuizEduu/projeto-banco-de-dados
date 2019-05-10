package controller;

import dao.ConsultaDao;
import model.Consulta;
import model.Hospital;
import model.Medico;
import model.Paciente;

public class ControllerConsulta {
	ConsultaDao consultaDao = new ConsultaDao();

	public void agendarConsulta(String diagnostico, String dataconsulta, long id_paciente, long id_hospital, long id_medico) {
		String dataconsultatemp = LimpaDados.converterDataConsulta(dataconsulta);
		Consulta consulta = new Consulta(diagnostico, dataconsultatemp, id_paciente, id_hospital, id_medico);
		consultaDao.agendarConsulta(consulta);
	}
	
	public void atualizarConsulta(String diagnostico, String dataconsulta, long id_paciente, long id_hospital, long id_medico) {
		String dataconsultatemp = LimpaDados.converterDataConsulta(dataconsulta);
		Consulta consulta = new Consulta(diagnostico,dataconsultatemp, id_paciente, id_hospital, id_medico);
		consultaDao.atualizarPaciente(consulta);
	}
	
	public Consulta buscarConsulta(long idconsulta) {
		Consulta consulta = new Consulta();
		consulta = consultaDao.buscarConsulta(idconsulta);
		String datatemp = LimpaDados.converterDataConsultaBusca(consulta.getDataconsulta());
		consulta.setDataconsulta(datatemp);
		return consulta;
	}

	public Paciente buscarDadosPaciente(String cpfPaciente) {
		Paciente paciente = new Paciente();
		String cpftemp = LimpaDados.limpaAll(cpfPaciente);
		paciente = consultaDao.BuscarDadosPaciente(cpftemp);
		return paciente;
	}

	public Hospital buscarDadosHospital(String cnpjHospital) {
		Hospital hospital = new Hospital();
		String cnpjtemp = LimpaDados.limpaAll(cnpjHospital);
		hospital = consultaDao.BuscarDadosHospital(cnpjtemp);
		return hospital;
	}

	public Medico buscarDadosMedico(String cpf) {
		Medico medico = new Medico();
		String cpftemp = LimpaDados.limpaAll(cpf);
		medico = consultaDao.BuscarDadosMedico(cpftemp);
		return medico;
	}
}
