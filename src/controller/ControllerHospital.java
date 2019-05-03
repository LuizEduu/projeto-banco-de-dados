package controller;

import java.util.ArrayList;

import dao.HospitalDao;
import model.Hospital;

public class ControllerHospital {
	HospitalDao hospitalDao = new HospitalDao();

	public void cadastrarHospital(String nome, String cnpj, String telefone, String rua, String bairro, String cidade) {

	}

	public Hospital buscarHospital(long id) {
		Hospital hospital = new Hospital();

		return hospital;
	}

	public void atualizarHospital(long id, String nome, String cnpj, String telefone, String rua, String bairro,
			String cidade) {

	}

	public void removerHospital(long id) {

	}

	public ArrayList<Hospital> listarHospital() {
		ArrayList<Hospital> arrayList = new ArrayList<Hospital>();
		arrayList = hospitalDao.Listar();
		return arrayList;
	}
}
