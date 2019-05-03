package controller;

import java.util.ArrayList;

import dao.HospitalDao;
import model.Hospital;
import model.TelefoneHospital;

public class ControllerHospital {
	HospitalDao hospitalDao = new HospitalDao();

	public void cadastrarHospital(String nome, String cnpj, String telefone, String rua, String bairro, String cidade) {

		String cnpjtemp = LimpaDados.limpaAll(cnpj);
		String telefonetemp = LimpaDados.limpaAll(telefone);
		Hospital hospital = new Hospital(nome, cnpjtemp, rua, bairro, cidade);
		TelefoneHospital telefoneHospital = new TelefoneHospital(telefonetemp);
		hospitalDao.Salvar(hospital, telefoneHospital);
	}

	public Hospital buscarHospital(long id) {
		Hospital hospital = new Hospital();
		hospital = hospitalDao.buscar(id);
		return hospital;
	}

	public void atualizarHospital(long id, String nome, String cnpj, String telefone, String rua, String bairro,
			String cidade) {
		String cnpjtemp = LimpaDados.limpaAll(cnpj);
		String telefonetemp = LimpaDados.limpaAll(telefone);
		Hospital hospital = new Hospital(nome, cnpjtemp, rua, bairro, cidade);
		TelefoneHospital telefoneHospital = new TelefoneHospital(telefonetemp);
		hospitalDao.atualizarHospital(id, hospital, telefoneHospital);
	}

	public void removerHospital(long id) {

		hospitalDao.removerHospital(id);
	}

	public ArrayList<Hospital> listarHospital() {
		ArrayList<Hospital> arrayList = new ArrayList<Hospital>();
		arrayList = hospitalDao.Listar();
		return arrayList;
	}
}
