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
		hospital = consultaDao.BuscarDadosHospital(cnpjHospital);
		return hospital;

	}

	public Medico buscarDadosMedico(String cpf) {
		Medico medico = new Medico();
		medico = consultaDao.BuscarDadosMedico(cpf);
		return medico;
	}
}
