package controller;

import controller.LimpaDados;
import dao.PacienteDao;
import model.EnderecoPaciente;
import model.Paciente;
import model.TelefonePaciente;

public class ControllerPaciente {

	PacienteDao dao = new PacienteDao();

	public void cadastrarPaciente(String nome, String sexo, String email, String telefone, String rua, String numero,
			String bairro, String cidade, String datanascimento) {

		String telefonetemp = LimpaDados.limpatelefone(telefone);
		String datatemp = LimpaDados.converterData(datanascimento);
		Paciente paciente = new Paciente(nome, sexo, email, datatemp);
		TelefonePaciente telefonePaciente = new TelefonePaciente(telefonetemp);
		EnderecoPaciente enderecoPaciente = new EnderecoPaciente(rua, numero, bairro, cidade);
		dao.Salvar(paciente, telefonePaciente, enderecoPaciente);
	}

	/*
	 * 
	 * public Paciente buscarPaciente(int id) { Paciente paciente = dao.buscar(id);
	 * String datatemp = LimpaDados.converterDataBusca(paciente.getNascimento());
	 * paciente.setNascimento(datatemp); return paciente; }
	 * 
	 * public void atualizarpaciente(int id, String nome, String sexo, String email,
	 * String telefone, String rua, String numero, String bairro, String cidade,
	 * String datanascimento) {
	 * 
	 * String datatemp = LimpaDados.converterData(datanascimento); // Paciente
	 * paciente = new Paciente(nome, sexo, email, telefone, rua, numero, bairro,
	 * cidade, datatemp); //dao.atualizarpaciente(id, paciente); }
	 * 
	 * 
	 * 
	 * public void removerpaciente(int id, String nome, String sexo, String email,
	 * String telefone, String rua, String numero, String bairro, String cidade,
	 * String datanascimento) {
	 * 
	 * dao.removerpaciente(id); }
	 * 
	 * public ArrayList<Paciente> listarpaciente() { ArrayList<Paciente> list =
	 * dao.Listar(); return list; }
	 * 
	 */

}
