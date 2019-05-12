package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.EnderecoPaciente;
import model.Paciente;
import model.TelefonePaciente;
import singeconnection.SingeConnection;

public class PacienteDao {

	private Connection connection;

	public PacienteDao() {
		this.connection = SingeConnection.getConnection();
	}

	public void Salvar(Paciente paciente, TelefonePaciente telefonePaciente, EnderecoPaciente enderecoPaciente) {
		try {

			String sql = "insert into paciente (nomepaciente, cpfpaciente, sexopaciente, email, datanascimento) values (?, ?, ?, ?, ?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, paciente.getNome());
			preparedStatement.setString(2, paciente.getCpf());
			preparedStatement.setString(3, paciente.getSexo());
			preparedStatement.setString(4, paciente.getEmail());
			preparedStatement.setString(5, paciente.getNascimento());
			preparedStatement.execute();

			int lastId = 0;
			final ResultSet rs = preparedStatement.getGeneratedKeys();
			if (rs.next()) {
				lastId = rs.getInt(1);
			}

			String sql2 = "insert into telefonepaciente (numerotelefonepaciente, id_paciente) values (?, ?)";
			PreparedStatement preparedStatement2 = connection.prepareStatement(sql2);
			preparedStatement2.setString(1, telefonePaciente.getNumero());
			preparedStatement2.setInt(2, lastId);

			String sql3 = "insert into enderecopaciente (ruapaciente, numeropaciente, bairropaciente, cidadepaciente, id_paciente) values(?, ?, ?, ?, ?)";
			PreparedStatement preparedStatement3 = connection.prepareStatement(sql3);
			preparedStatement3.setString(1, enderecoPaciente.getRua());
			preparedStatement3.setString(2, enderecoPaciente.getNumero());
			preparedStatement3.setString(3, enderecoPaciente.getBairro());
			preparedStatement3.setString(4, enderecoPaciente.getCidade());
			preparedStatement3.setInt(5, lastId);
			preparedStatement2.execute();
			preparedStatement3.execute();
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

	public Paciente buscar(Long id) {
		Paciente paciente = new Paciente();
		try {
			String sql = "select p.nomepaciente, p.cpfpaciente, p.sexopaciente, p.email, t.numerotelefonepaciente, e.ruapaciente, "
					+ "e.numeropaciente, e.bairropaciente, "
					+ "e.cidadepaciente, p.datanascimento " + "from paciente p "
					+ "inner join telefonepaciente t ON t.id_paciente = p.idpaciente "
					+ "inner join enderecopaciente e ON e.id_paciente = p.idpaciente "
					+ "where p.idpaciente = ?";

			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setLong(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				paciente.setNome(resultSet.getString("nomepaciente"));
				paciente.setCpf(resultSet.getString("cpfpaciente"));
				paciente.setSexo(resultSet.getString("sexopaciente"));
				paciente.setEmail(resultSet.getString("email"));
				paciente.getTelefonePaciente().setNumero(resultSet.getString("numerotelefonepaciente"));
				paciente.getEnderecoPaciente().setRua(resultSet.getString("ruapaciente"));
				paciente.getEnderecoPaciente().setNumero(resultSet.getString("numeropaciente"));
				paciente.getEnderecoPaciente().setBairro(resultSet.getString("bairropaciente"));
				paciente.getEnderecoPaciente().setCidade(resultSet.getString("cidadepaciente"));
				paciente.setNascimento(resultSet.getString("datanascimento"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return paciente;
	}

	public void atualizarpaciente(Long id, Paciente paciente, TelefonePaciente telefonePaciente,
			EnderecoPaciente enderecoPaciente) {
		try {
			String sql = "update paciente set nomepaciente= ?, cpfpaciente= ?, sexopaciente= ?, email= ?, datanascimento= ? "
					   + "where idpaciente= ? ";
			String sql2 = "update telefonepaciente set numerotelefonepaciente= ? "
						+ "where id_paciente= ?";
			String sql3 = "update enderecopaciente set ruapaciente= ?, numeropaciente= ?, bairropaciente= ?, cidadepaciente= ? "
					    + "where id_paciente= ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			PreparedStatement preparedStatement2 = connection.prepareStatement(sql2);
			PreparedStatement preparedStatement3 = connection.prepareStatement(sql3);

			preparedStatement.setString(1, paciente.getNome());
			preparedStatement.setString(2, paciente.getCpf());
			preparedStatement.setString(3, paciente.getSexo());
			preparedStatement.setString(4, paciente.getEmail());
			preparedStatement.setString(5, paciente.getNascimento());
			preparedStatement.setLong(6, id);

			preparedStatement2.setString(1, telefonePaciente.getNumero());
			preparedStatement2.setLong(2, id);

			preparedStatement3.setString(1, enderecoPaciente.getRua());
			preparedStatement3.setString(2, enderecoPaciente.getNumero());
			preparedStatement3.setString(3, enderecoPaciente.getBairro());
			preparedStatement3.setString(4, enderecoPaciente.getCidade());
			preparedStatement3.setLong(5, id);

			preparedStatement.executeUpdate();
			preparedStatement2.executeUpdate();
			preparedStatement3.executeUpdate();
			connection.commit();

		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}

	}

	public void removerpaciente(int id) {

		try {
			String sql = "delete from enderecopaciente where  id_paciente = ?";
			String sql2 = "delete from telefonepaciente where id_paciente = ?";
			String sql3 = "delete from paciente where idpaciente = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			PreparedStatement preparedStatement2 = connection.prepareStatement(sql2);
			PreparedStatement preparedStatement3 = connection.prepareStatement(sql3);
			preparedStatement.setInt(1, id);
			preparedStatement2.setInt(1, id);
			preparedStatement3.setInt(1, id);
			preparedStatement.executeUpdate();
			preparedStatement2.executeUpdate();
			preparedStatement3.executeUpdate();
			connection.commit();
		} catch (Exception e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}

	public ArrayList<Paciente> Listar() {
		ArrayList<Paciente> list = new ArrayList<Paciente>();
		try {
			String sql = "select p.idpaciente, p.nomepaciente, p.cpfpaciente, p.sexopaciente, p.email, "
					+ "t.numerotelefonepaciente , e.ruapaciente , e.numeropaciente , "
					+ "e.bairropaciente, e.cidadepaciente, p.datanascimento "
					+ "from paciente p "
					+ "inner join telefonepaciente t ON t.id_paciente = p.idpaciente "
					+ "inner join enderecopaciente e ON e.id_paciente = p.idpaciente";

			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Paciente paciente = new Paciente();
				paciente.setId(resultSet.getLong("idpaciente"));
				paciente.setNome(resultSet.getString("nomepaciente"));
				paciente.setCpf(resultSet.getString("cpfpaciente"));
				paciente.setSexo(resultSet.getString("sexopaciente"));
				paciente.setEmail(resultSet.getString("email"));
				paciente.getTelefonePaciente().setNumero(resultSet.getString("numerotelefonepaciente"));
				paciente.getEnderecoPaciente().setRua(resultSet.getString("ruapaciente"));
				paciente.getEnderecoPaciente().setNumero(resultSet.getString("numeropaciente"));
				paciente.getEnderecoPaciente().setBairro(resultSet.getString("bairropaciente"));
				paciente.getEnderecoPaciente().setCidade(resultSet.getString("cidadepaciente"));
				paciente.setNascimento(resultSet.getString("datanascimento"));
				list.add(paciente);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

}