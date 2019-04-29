package controller;

import java.util.ArrayList;

import dao.MedicoDao;
import model.EnderecoMedico;
import model.Medico;
import model.TelefoneMedico;

public class ControllerMedico {

	MedicoDao dao = new MedicoDao();

	public void cadastrarMedico(String nome, String cpf, String sexo, String especialidade, String crm, String telefone, String rua,
			String numero, String bairro, String cidade) {

		String telefonetemp = LimpaDados.limpatelefone(telefone);
		String cpftemp = LimpaDados.limpacpf(cpf);
		Medico medico = new Medico(nome, cpftemp, sexo, especialidade, crm);
		TelefoneMedico telefoneMedico = new TelefoneMedico(telefonetemp);
		EnderecoMedico enderecoMedico = new EnderecoMedico(rua, numero, bairro, cidade);
		dao.Salvar(medico, telefoneMedico, enderecoMedico);
	}

	public Medico buscarMedico(Long id) {
		Medico retorno = dao.buscar(id);
		return retorno;
	}

	public void atualizarMedico(Long id, String nome, String cpf, String sexo, String especialidade, String crm,  String telefone,
			String rua, String numero, String bairro, String cidade) {

		String cpftemp = LimpaDados.limpacpf(cpf);
		String telefonetemp = LimpaDados.limpatelefone(telefone);
		Medico medico = new Medico(nome, cpftemp, sexo, especialidade, crm);
		TelefoneMedico telefoneMedico = new TelefoneMedico(telefonetemp);
		EnderecoMedico enderecoMedico = new EnderecoMedico(rua, numero, bairro, cidade);
		dao.atualizarMedico(id, medico, telefoneMedico, enderecoMedico);
	}

	public void removerMedico(int id) {
		dao.removerMedico(id);
	}

	public ArrayList<Medico> listarMedico() {
		ArrayList<Medico> list = dao.Listar();
		return list;
	}

}
