package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.EnderecoMedico;
import model.Medico;
import model.TelefoneMedico;
import singeconnection.SingeConnection;

public class MedicoDao {

	private Connection connection;

	public MedicoDao() {
		this.connection = SingeConnection.getConnection();
	}

	public void Salvar(Medico medico, TelefoneMedico telefoneMedico, EnderecoMedico enderecoMedico) {
		try {

			String sql = "insert into medico (nome, cpf, sexo, especialidade, crm) values (?, ?, ?, ?, ?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, medico.getNome());
			preparedStatement.setString(2, medico.getCpf());
			preparedStatement.setString(3, medico.getSexo());
			preparedStatement.setString(4, medico.getEspecialidade());
			preparedStatement.setString(5, medico.getCrm());
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

			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}

	}

	public Medico buscar(Long id) {
		Medico medico = new Medico();
		try {
			String sql = "select m.nome, m.cpf, m.sexo, m.especialidade, m.crm, t.numerotelefone, e.rua, e.numero, "
					+ "e.bairro, e.cidade "
					+ "from medico m "
					+ "inner join telefonemedico t ON t.id_medico = m.idmedico "
					+ "inner join enderecomedico e ON e.id_medico = m.idmedico "
					+ "where m.idmedico = ?";

			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setLong(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				medico.setNome(resultSet.getString("nome"));
				medico.setCpf(resultSet.getString("cpf"));
				medico.setSexo(resultSet.getString("sexo"));
				medico.setEspecialidade(resultSet.getString("especialidade"));
				medico.setCrm(resultSet.getString("crm"));
				medico.getTelefoneMedico().setNumero(resultSet.getString("numerotelefone"));
				medico.getEnderecoMedico().setRua(resultSet.getString("rua"));
				medico.getEnderecoMedico().setNumero(resultSet.getString("numero"));
				medico.getEnderecoMedico().setBairro(resultSet.getString("bairro"));
				medico.getEnderecoMedico().setCidade(resultSet.getString("cidade"));
			}
		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();

		}
		return medico;

	}

	public void atualizarMedico(Long id, Medico medico, TelefoneMedico telefoneMedico, EnderecoMedico enderecoMedico) {
		try {
			String sql = "update medico set nome= ?, set cpf= ?, sexo= ?, especialidade= ?, crm= ?, where idmedico= ?";
			String sql2 = "update telefonemedico set numerotelefone= ? where id_medico= ?";
			String sql3 = "update enderecomedico set rua= ?, numero= ?, bairro= ?, cidade= ? where id_medico= ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			PreparedStatement preparedStatement2 = connection.prepareStatement(sql2);
			PreparedStatement preparedStatement3 = connection.prepareStatement(sql3);

			preparedStatement.setString(1, medico.getNome());
			preparedStatement.setString(2, medico.getCpf());
			preparedStatement.setString(3, medico.getSexo());
			preparedStatement.setString(4, medico.getEspecialidade());
			preparedStatement.setString(5, medico.getCrm());
			preparedStatement.setLong(6, id);

			preparedStatement2.setString(1, telefoneMedico.getNumero());
			preparedStatement2.setLong(2, id);

			preparedStatement3.setString(1, enderecoMedico.getRua());
			preparedStatement3.setString(2, enderecoMedico.getNumero());
			preparedStatement3.setString(3, enderecoMedico.getBairro());
			preparedStatement3.setString(4, enderecoMedico.getCidade());
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

	public void removerMedico(int id) {

		try {
			String sql = "delete from enderecomedico where  id_medico = ?";
			String sql2 = "delete from telefonemedico where id_medico = ?";
			String sql3 = "delete from medico where idmedico = ?";
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

	public ArrayList<Medico> Listar() {
		ArrayList<Medico> list = new ArrayList<Medico>();
		try {
			String sql = "select m.idmedico, m.nome, m.cpf, m.sexo, m.especialidade, m.crm, t.numerotelefone, e.rua, e.numero, "
					+ "e.bairro, e.cidade from medico m "
					+ "inner join telefonemedico t ON t.id_medico = m.idmedico "
					+ "inner join enderecomedico e ON e.id_medico = m.idmedico";

			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Medico medico = new Medico();
				medico.setId(resultSet.getLong("idpaciente"));
				medico.setNome(resultSet.getString("nome"));
				medico.setCpf(resultSet.getString("cpf"));
				medico.setEspecialidade(resultSet.getString("especialidade"));
				medico.setCrm(resultSet.getString("crm"));
				medico.getTelefoneMedico().setNumero(resultSet.getString("numerotelefone"));
				medico.getEnderecoMedico().setRua(resultSet.getString("rua"));
				medico.getEnderecoMedico().setNumero(resultSet.getString("numero"));
				medico.getEnderecoMedico().setBairro(resultSet.getString("bairro"));
				medico.getEnderecoMedico().setCidade(resultSet.getString("cidade"));
				list.add(medico);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

}
