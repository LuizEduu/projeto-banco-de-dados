package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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

	public void atualizarConsulta(long id, Consulta consulta) {
		try {
			String sql = "update consulta set id_paciente= ?, id_medico=?, id_hospital= ?, data= ?, diagnostico= ? "
					+ "where idconsulta=?";

			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setLong(1, consulta.getId_paciente());
			preparedStatement.setLong(2, consulta.getId_medico());
			preparedStatement.setLong(3, consulta.getId_hospital());
			preparedStatement.setString(4, consulta.getDataconsulta());
			preparedStatement.setString(5, consulta.getDiagnostico());
			preparedStatement.setLong(6, id);
			preparedStatement.executeUpdate();
			connection.commit();

		} catch (Exception e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
	}

	public void cancelarConsulta(long id) {
		try {
			String sql = "delete from consulta where idconsulta = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setLong(1, id);
			preparedStatement.executeUpdate();
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
			String sql = "SELECT C.IDCONSULTA, P.NOMEPACIENTE , P.CPFPACIENTE, TP.NUMEROTELEFONEPACIENTE, P.SEXOPACIENTE, "
					+ "H.NOMEHOSPITAL , H.CNPJHOSPITAL, TH.NUMEROTELEFONEHOSPITAL, "
					+ "H.RUAHOSPITAL, H.BAIRROHOSPITAL, H.CIDADEHOSPITAL, "
					+ "M.NOMEMEDICO , M.CPFMEDICO, M.CRMMEDICO, M.ESPECIALIDADEMEDICO, " + "C.DATA, C.DIAGNOSTICO "
					+ "FROM CONSULTA C " + "INNER JOIN PACIENTE P ON P.IDPACIENTE = C.ID_PACIENTE "
					+ "INNER JOIN HOSPITAL H ON H.IDHOSPITAL = C.ID_HOSPITAL "
					+ "INNER JOIN MEDICO M ON M.IDMEDICO = C.ID_MEDICO "
					+ "INNER JOIN TELEFONEPACIENTE TP ON TP.ID_PACIENTE = P.IDPACIENTE "
					+ "INNER JOIN TELEFONEHOSPITAL TH ON TH.ID_HOSPITAL = H.IDHOSPITAL " + "WHERE C.IDCONSULTA = ?";

			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setLong(1, idconsulta);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				consulta.setIdconsulta(resultSet.getLong("idconsulta"));
				consulta.getPaciente().setNome(resultSet.getString("nomepaciente"));
				consulta.getPaciente().setCpf(resultSet.getString("cpfpaciente"));
				consulta.getPaciente().getTelefonePaciente().setNumero(resultSet.getString("numerotelefonepaciente"));
				consulta.getPaciente().setSexo(resultSet.getString("sexopaciente"));
				consulta.getHospital().setNome(resultSet.getString("nomehospital"));
				consulta.getHospital().setCnpj(resultSet.getString("cnpjhospital"));
				consulta.getHospital().getTelefoneHospital()
						.setNumerotelefone(resultSet.getString("numerotelefonehospital"));
				consulta.getHospital().setRua(resultSet.getString("ruahospital"));
				consulta.getHospital().setBairro(resultSet.getString("bairrohospital"));
				consulta.getHospital().setCidade(resultSet.getString("cidadehospital"));
				consulta.getMedico().setNome(resultSet.getString("nomemedico"));
				consulta.getMedico().setCpf(resultSet.getString("cpfmedico"));
				consulta.getMedico().setCrm(resultSet.getString("crmmedico"));
				consulta.getMedico().setEspecialidade(resultSet.getString("especialidademedico"));
				consulta.setDataconsulta(resultSet.getString("data"));
				consulta.setDiagnostico(resultSet.getString("diagnostico"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return consulta;
	}

	public Paciente BuscarDadosPaciente(String cpfPaciente) {
		Paciente paciente = new Paciente();
		try {
			String sql = "select p.idpaciente, p.nomepaciente, p.cpfpaciente, p.sexopaciente, t.numerotelefonepaciente "
					+ "from paciente p " + "inner join telefonepaciente t ON t.id_paciente = p.idpaciente "
					+ "where p.cpfpaciente = ? ";

			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, cpfPaciente);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				paciente.setId(resultSet.getLong("idpaciente"));
				paciente.setNome(resultSet.getString("nomepaciente"));
				paciente.setCpf(resultSet.getString("cpfpaciente"));
				paciente.setSexo(resultSet.getString("sexopaciente"));
				paciente.getTelefonePaciente().setNumero(resultSet.getString("numerotelefonepaciente"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return paciente;
	}

	public Hospital BuscarDadosHospital(String cnpj) {
		Hospital hospital = new Hospital();
		try {
			String sql = "select h.idhospital, h.nomehospital, h.cnpjhospital, t.numerotelefonehospital, h.ruahospital, "
					+ "h.bairrohospital, h.cidadehospital " + "from hospital h "
					+ "inner join telefonehospital t ON t.id_hospital = h.idhospital " + "where h.cnpjhospital = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, cnpj);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				hospital.setIdhospital(resultSet.getLong("idhospital"));
				hospital.setNome(resultSet.getString("nomehospital"));
				hospital.setCnpj(resultSet.getString("cnpjhospital"));
				hospital.getTelefoneHospital().setNumerotelefone(resultSet.getString("numerotelefonehospital"));
				hospital.setRua(resultSet.getString("ruahospital"));
				hospital.setBairro(resultSet.getString("bairrohospital"));
				hospital.setCidade(resultSet.getString("cidadehospital"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return hospital;
	}
	

	public Medico BuscarDadosMedico(String cpf) {
		Medico medico = new Medico();
		try {
			String sql = "select m.idmedico, m.nomemedico, m.cpfmedico, m.crmmedico, m.especialidademedico "
					+ "from medico m " + "where m.cpfmedico = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, cpf);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				medico.setId(resultSet.getLong("idmedico"));
				medico.setNome(resultSet.getString("nomemedico"));
				medico.setCpf(resultSet.getString("cpfmedico"));
				medico.setCrm(resultSet.getString("crmmedico"));
				medico.setEspecialidade(resultSet.getString("especialidademedico"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return medico;
	}

	public ArrayList<Consulta> relatoriosConsulta() {
		ArrayList<Consulta> arrayList = new ArrayList<Consulta>();
		try{
			String sql = "select c.idconsulta, p.nomepaciente, p.cpfpaciente, tp.numerotelefonepaciente, m.nomemedico, m.crmmedico, "
					+ "h.nomehospital, h.cnpjhospital, c.data, c.diagnostico "
					+ "from consulta c "
					+ "inner join paciente p ON p.idpaciente = c.id_paciente "
					+ "inner join telefonepaciente tp ON tp.id_paciente = p.idpaciente "
					+ "inner join medico m ON m.idmedico = c.id_medico "
					+ "inner join hospital h ON h.idhospital = c.id_hospital";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				Consulta consulta = new Consulta();
				consulta.setIdconsulta(resultSet.getLong("idconsulta"));
				consulta.getPaciente().setNome(resultSet.getString("nomepaciente"));
				consulta.getPaciente().setCpf(resultSet.getString("cpfpaciente"));
				consulta.getPaciente().getTelefonePaciente().setNumero(resultSet.getString("numerotelefonepaciente"));
				consulta.getMedico().setNome(resultSet.getString("nomemedico"));
				consulta.getMedico().setCrm(resultSet.getString("crmmedico"));
				consulta.getHospital().setNome(resultSet.getString("nomehospital"));
				consulta.getHospital().setCnpj(resultSet.getString("cnpjhospital"));
				consulta.setDataconsulta(resultSet.getString("data"));
				consulta.setDiagnostico(resultSet.getString("diagnostico"));
				arrayList.add(consulta);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return arrayList;
	}
}
