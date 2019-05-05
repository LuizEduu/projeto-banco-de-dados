package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Hospital;
import model.Medico;
import model.Paciente;
import singeconnection.SingeConnection;

public class ConsultaDao {

	private Connection connection;

	public ConsultaDao() {
		this.connection = SingeConnection.getConnection();
	}

	public Paciente BuscarDadosPaciente(String cpfPaciente) {
		Paciente paciente = new Paciente();
		try {
			String sql = "select p.nome, p.sexo, t.numerotelefone " 
					+ "from paciente p "
					+ "inner join telefonepaciente t ON t.id_paciente = p.idpaciente " 
					+ "where p.cpf = ?";

			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, cpfPaciente);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				paciente.setNome(resultSet.getString("nome"));
				paciente.setSexo(resultSet.getString("Sexo"));
				paciente.getTelefonePaciente().setNumero(resultSet.getString("numerotelefone"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return paciente;
	}

	public Hospital BuscarDadosHospital(String cnpj) {
		Hospital hospital = new Hospital();
		try {
			String sql = "select h.nome, t.numerotelefone, h.rua, h.bairro, h.cidade " 
					+ "from hospital h "
					+ "inner join telefonehospital t ON t.id_hospital = h.idhospital" + "where h.cnpj = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, cnpj);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				hospital.setNome(resultSet.getString("nome"));
				hospital.getTelefoneHospital().setNumerotelefone(resultSet.getString("numerotelefone"));
				hospital.setRua(resultSet.getString("rua"));
				hospital.setBairro(resultSet.getString("bairro"));
				hospital.setCidade(resultSet.getString("cidade"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return hospital;
	}

	public Medico BuscarDadosMedico(String cpf) {
		Medico medico = new Medico();
		try {
			String sql = "select m.nome, m.crm, m.especialidade " 
					+ "from medico m" 
					+ "where m.cpf = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, cpf);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				medico.setNome(resultSet.getString("nome"));
				medico.setCrm(resultSet.getString("crm"));
				medico.setEspecialidade(resultSet.getString("especialidade"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return medico;
	}
}
