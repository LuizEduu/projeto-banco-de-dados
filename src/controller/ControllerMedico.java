package controller;

import dao.MedicoDao;
import model.EnderecoMedico;
import model.Medico;
import model.TelefoneMedico;

public class ControllerMedico {

	MedicoDao dao = new MedicoDao();

	public void cadastrarMedico(String nome, String sexo, String email, String especialidade, String telefone, String rua, String numero,
			String bairro, String cidade, String datanascimento) {

		String telefonetemp = LimpaDados.limpatelefone(telefone);
		String datatemp = LimpaDados.converterData(datanascimento);
		Medico paciente = new Medico(nome, sexo, especialidade);
		TelefoneMedico telefoneMedico = new TelefoneMedico(telefonetemp);
		EnderecoMedico enderecoMedico = new EnderecoMedico(rua, numero, bairro, cidade);
		//dao.Salvar(paciente, telefonePaciente, enderecoPaciente);
	}

	/*public Paciente buscarPaciente(Long id) {
		Paciente retorno = dao.buscar(id);
		String datatemp = LimpaDados.converterDataBusca(retorno.getNascimento());
		retorno.setNascimento(datatemp);
		return retorno;
	
	}
	
	public void atualizarpaciente(Long id, String nome, String sexo, String email, String telefone, String rua,
			String numero, String bairro, String cidade, String datanascimento) {

		String datatemp = LimpaDados.converterData(datanascimento);
		Paciente paciente = new Paciente(nome, sexo, email, datatemp);
		TelefonePaciente telefonePaciente = new TelefonePaciente(telefone);
		EnderecoPaciente enderecoPaciente = new EnderecoPaciente(rua, numero, bairro, cidade);
		dao.atualizarpaciente(id, paciente, telefonePaciente, enderecoPaciente);
	}

	public void removerpaciente(int id, String nome, String sexo, String email, String telefone, String rua,
			String numero, String bairro, String cidade, String datanascimento) {
		dao.removerpaciente(id);
	}

	public ArrayList<Paciente> listarpaciente() {
		ArrayList<Paciente> list = dao.Listar();
		return list;
	}
	
	*/
}
