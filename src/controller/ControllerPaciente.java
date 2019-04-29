package controller;

import java.util.ArrayList;

import dao.PacienteDao;
import model.EnderecoPaciente;
import model.Paciente;
import model.TelefonePaciente;

public class ControllerPaciente {

	PacienteDao dao = new PacienteDao();

	public void cadastrarPaciente(String nome, String cpf, String sexo, String email, String telefone, String rua, String numero,
			String bairro, String cidade, String datanascimento) {

		String telefonetemp = LimpaDados.limpatelefone(telefone);
		String datatemp = LimpaDados.converterData(datanascimento);
		String cpftemp = LimpaDados.limpacpf(cpf);
		Paciente paciente = new Paciente(nome, cpftemp,  sexo, email, datatemp);
		TelefonePaciente telefonePaciente = new TelefonePaciente(telefonetemp);
		EnderecoPaciente enderecoPaciente = new EnderecoPaciente(rua, numero, bairro, cidade);
		dao.Salvar(paciente, telefonePaciente, enderecoPaciente);
	}

	public Paciente buscarPaciente(Long id) {
		Paciente retorno = dao.buscar(id);
		String datatemp = LimpaDados.converterDataBusca(retorno.getNascimento());
		retorno.setNascimento(datatemp);
		return retorno;
	}

	public void atualizarpaciente(Long id, String nome, String cpf,  String sexo, String email, String telefone, String rua,
			String numero, String bairro, String cidade, String datanascimento) {

		String datatemp = LimpaDados.converterData(datanascimento);
		String cpftemp = LimpaDados.limpacpf(cpf);
		Paciente paciente = new Paciente(nome, cpftemp,  sexo, email, datatemp);
		TelefonePaciente telefonePaciente = new TelefonePaciente(telefone);
		EnderecoPaciente enderecoPaciente = new EnderecoPaciente(rua, numero, bairro, cidade);
		dao.atualizarpaciente(id, paciente, telefonePaciente, enderecoPaciente);
	}

	public void removerpaciente(int id) {
		dao.removerpaciente(id);
	}

	public ArrayList<Paciente> listarpaciente() {
		ArrayList<Paciente> list = dao.Listar();
		return list;
	}

}
