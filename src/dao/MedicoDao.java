package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.EnderecoMedico;
import model.EnderecoPaciente;
import model.Medico;
import model.Paciente;
import model.TelefoneMedico;
import model.TelefonePaciente;
import singeconnection.SingeConnection;

public class MedicoDao {

	private Connection connection;

	public MedicoDao() {
		this.connection = SingeConnection.getConnection();
	}

	public void Salvar(Medico medico, TelefoneMedico telefoneMedico, EnderecoMedico enderecoMedico) {
		try {

			String sql = "insert into medico (nome, sexo, especialidade) values (?, ?, ?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, medico.getNome());
			preparedStatement.setString(2, medico.getSexo());
			preparedStatement.setString(3, medico.getEspecialidade());
			preparedStatement.execute();

			int lastId = 0;
			final ResultSet rs = preparedStatement.getGeneratedKeys();
			if (rs.next()) {
				lastId = rs.getInt(1);
			}

			String sql2 = "insert into telefonemedico (numerotelefone, id_medico) values (?,?)";
			PreparedStatement preparedStatement2 = connection.prepareStatement(sql2);
			preparedStatement2.setString(1, telefoneMedico.getNumero());
			preparedStatement2.setInt(2, lastId);

			String sql3 = "insert into enderecomedico (rua, numero, bairro, cidade, id_medico) values(?, ?, ?, ?, ?)";
			PreparedStatement preparedStatement3 = connection.prepareStatement(sql3);
			preparedStatement3.setString(1, enderecoMedico.getRua());
			preparedStatement3.setString(2, enderecoMedico.getNumero());
			preparedStatement3.setString(3, enderecoMedico.getBairro());
			preparedStatement3.setString(4, enderecoMedico.getCidade());
			preparedStatement3.setInt(5, lastId);
			preparedStatement2.execute();
			preparedStatement3.execute();

			connection.commit();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public Paciente buscar(Long id) {
		Paciente paciente = new Paciente();
		try {
			String sql = "select p.nome, p.sexo, p.email, t.numerotelefone, e.rua, e.numero, e.bairro, e.cidade, p.nascimento "
					+ "from paciente p " + "inner join telefonepaciente t ON t.id_paciente = p.idpaciente "
					+ "inner join enderecopaciente e ON e.id_paciente = p.idpaciente " + "where idpaciente = ?";

			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setLong(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				paciente.setNome(resultSet.getString("nome"));
				paciente.setSexo(resultSet.getString("sexo"));
				paciente.setEmail(resultSet.getString("email"));
				paciente.getTelefonePaciente().setTelefone(resultSet.getString("numerotelefone"));
				paciente.getEnderecoPaciente().setRua(resultSet.getString("rua"));
				paciente.getEnderecoPaciente().setNumero(resultSet.getString("numero"));
				paciente.getEnderecoPaciente().setBairro(resultSet.getString("bairro"));
				paciente.getEnderecoPaciente().setCidade(resultSet.getString("cidade"));
				paciente.setNascimento(resultSet.getString("nascimento"));
			}
		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();

		}
		return paciente;

	}

	public void atualizarpaciente(Long id, Paciente paciente, TelefonePaciente telefonePaciente,
			EnderecoPaciente enderecoPaciente) {
		try {
			String sql = "update paciente set nome= ?, sexo= ?, email= ?,nascimento= ? where idpaciente= ?";
			String sql2 = "update telefonepaciente set numerotelefone= ? where idtelefonepaciente= ?";
			String sql3 = "update enderecopaciente set rua= ?, numero= ?, bairro= ?, cidade= ? where idenderecopaciente= ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			PreparedStatement preparedStatement2 = connection.prepareStatement(sql2);
			PreparedStatement preparedStatement3 = connection.prepareStatement(sql3);

			preparedStatement.setString(1, paciente.getNome());
			preparedStatement.setString(2, paciente.getSexo());
			preparedStatement.setString(3, paciente.getEmail());
			preparedStatement.setString(4, paciente.getNascimento());
			preparedStatement.setLong(5, id);

			preparedStatement2.setString(1, telefonePaciente.getTelefone());
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

		try {
			connection.close();
		} catch (SQLException e) {
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
			String sql = "select p.idpaciente, p.nome, p.sexo, p.email, t.numerotelefone, e.rua, e.numero, e.bairro, e.cidade, p.nascimento "
					+ "from paciente p " + "inner join telefonepaciente t ON t.id_paciente = p.idpaciente "
					+ "inner join enderecopaciente e ON e.id_paciente = p.idpaciente";

			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Paciente paciente = new Paciente();
				paciente.setId(resultSet.getLong("idpaciente"));
				paciente.setNome(resultSet.getString("nome"));
				paciente.setSexo(resultSet.getString("sexo"));
				paciente.setEmail(resultSet.getString("email"));
				paciente.getTelefonePaciente().setTelefone(resultSet.getString("numerotelefone"));
				paciente.getEnderecoPaciente().setRua(resultSet.getString("rua"));
				paciente.getEnderecoPaciente().setNumero(resultSet.getString("numero"));
				paciente.getEnderecoPaciente().setBairro(resultSet.getString("bairro"));
				paciente.getEnderecoPaciente().setCidade(resultSet.getString("cidade"));
				paciente.setNascimento(resultSet.getString("nascimento"));
				list.add(paciente);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

}
