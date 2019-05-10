package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Consulta;
import model.Hospital;
import model.Medico;
import model.Paciente;
import singeconnection.SingeConnection;

public class ConsultaDao {

	private Connection connection;

	public ConsultaDao() {
		this.connection = SingeConnection.getConnection();
	}

	public void agendarConsulta(Consulta consulta) {
		try {
			String sql = "insert into consulta (id_paciente, id_medico, _idhospital, data, diagnostico) values (?, ?, ?, ?, ?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setLong(1, consulta.getId_paciente());
			preparedStatement.setLong(2, consulta.getId_medico());
			preparedStatement.setLong(3, consulta.getId_hospital());
			preparedStatement.setString(4, consulta.getDataconsulta());
			preparedStatement.setString(5, consulta.getDiagnostico());
			preparedStatement.execute();
			connection.commit();
		} catch (Exception e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}

	public Consulta buscarConsulta(long idconsulta) {
		Consulta consulta = new Consulta();
		try {
			String sql = "SELECT C.IDCONSULTA, P.NOME , P.CPF, TP.NUMEROTELEFONE, P.SEXO,  H.NOME , H.CNPJ, TH.NUMEROTELEFONE, "
					+ "H.RUA, H.BAIRRO, H.CIDADE, M.NOME ,  M.CPF, M.CRM, M.ESPECIALIDADE, "
					+ "C.DATA, C.DIAGNOSTICO " 
					+ "FROM CONSULTA C "
					+ "INNER JOIN PACIENTE P ON P.IDPACIENTE = C.ID_PACIENTE "
					+ "INNER JOIN HOSPITAL H ON H.IDHOSPITAL = C.ID_HOSPITAL "
					+ "INNER JOIN MEDICO M ON M.IDMEDICO = C.ID_MEDICO "
					+ "INNER JOIN TELEFONEPACIENTE TP ON TP.ID_PACIENTE = P.IDPACIENTE "
					+ "INNER JOIN TELEFONEHOSPITAL TH ON TH.ID_HOSPITAL = H.IDHOSPITAL " 
					+ "WHERE C.IDCONSULTA = ?";

			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setLong(1, idconsulta);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				consulta.setIdconsulta(resultSet.getLong("idconsulta"));
				consulta.getPaciente().setNome(resultSet.getString("nome"));
				consulta.getPaciente().setCpf(resultSet.getString("cpf"));
				consulta.getPaciente().getTelefonePaciente().setNumero(resultSet.getString("numerotelefone"));
				consulta.getPaciente().setSexo(resultSet.getString("sexo"));
				consulta.getHospital().setNome(resultSet.getString("nome"));
				consulta.getHospital().setCnpj(resultSet.getString("cnpj"));
				consulta.getHospital().getTelefoneHospital().setNumerotelefone(resultSet.getString("numerotelefone"));
				consulta.getHospital().setRua(resultSet.getString("rua"));
				consulta.getHospital().setBairro(resultSet.getString("bairro"));
				consulta.getHospital().setCidade(resultSet.getString("cidade"));
				consulta.getMedico().setNome(resultSet.getString("nome"));
				consulta.getMedico().setCpf(resultSet.getString("cpf"));
				consulta.getMedico().setCrm(resultSet.getString("crm"));
				consulta.getMedico().setEspecialidade(resultSet.getString("especialidade"));
				consulta.setDataconsulta(resultSet.getString("data"));
				consulta.setDiagnostico(resultSet.getString("diagnostico"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return consulta;
	}

	
	public void atualizarPaciente(Consulta consulta) {
		try {

		} catch (Exception e) {

		}
	}

	public Paciente BuscarDadosPaciente(String cpfPaciente) {
		Paciente paciente = new Paciente();
		try {
			String sql = "select p.idpaciente, p.nome, p.cpf, p.sexo, t.numerotelefone " + "from paciente p "
					+ "inner join telefonepaciente t ON t.id_paciente = p.idpaciente " + "where p.cpf = ? ";

			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, cpfPaciente);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				paciente.setId(resultSet.getLong("idpaciente"));
				paciente.setNome(resultSet.getString("nome"));
				paciente.setCpf(resultSet.getString("cpf"));
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
			String sql = "select h.idhospital, h.nome, h.cnpj, t.numerotelefone, h.rua, h.bairro, h.cidade "
					+ "from hospital h " + "inner join telefonehospital t ON t.id_hospital = h.idhospital "
					+ "where h.cnpj = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, cnpj);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				hospital.setIdhospital(resultSet.getLong("idhospital"));
				hospital.setNome(resultSet.getString("nome"));
				hospital.setCnpj(resultSet.getString("cnpj"));
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
			String sql = "select m.idmedico, m.nome, m.cpf, m.crm, m.especialidade " + "from medico m "
					+ "where m.cpf = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, cpf);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				medico.setId(resultSet.getLong("idmedico"));
				medico.setNome(resultSet.getString("nome"));
				medico.setCpf(resultSet.getString("cpf"));
				medico.setCrm(resultSet.getString("crm"));
				medico.setEspecialidade(resultSet.getString("especialidade"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return medico;
	}
}
