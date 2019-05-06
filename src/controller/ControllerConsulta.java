package controller;

import dao.ConsultaDao;
import model.Hospital;
import model.Medico;
import model.Paciente;

public class ControllerConsulta {
	ConsultaDao consultaDao = new ConsultaDao();

	public void agendarConsulta() {

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
