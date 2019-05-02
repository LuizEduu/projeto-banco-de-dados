package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Hospital;
import model.TelefoneHospital;
import singeconnection.SingeConnection;

public class HospitalDao {

	private Connection connection;

	public HospitalDao() {
		this.connection = SingeConnection.getConnection();
	}

	public void Salvar(Hospital hospital, TelefoneHospital telefoneHospital) {

		try {
			String sql = "insert into hospital (nome, cnpj, rua, bairro, cidade) values (?, ?, ?, ?, ?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, hospital.getNome());
			preparedStatement.setString(2, hospital.getCnpj());
			preparedStatement.setString(3, hospital.getRua());
			preparedStatement.setString(4, hospital.getBairro());
			preparedStatement.setString(5, hospital.getCidade());
			preparedStatement.execute();

			int lastId = 0;
			final ResultSet rs = preparedStatement.getGeneratedKeys();
			if (rs.next()) {
				lastId = rs.getInt(1);
			}

			String sql2 = "insert into telefonehospital (numerotelefone, id_hospital) values (?,?)";
			PreparedStatement preparedStatement2 = connection.prepareStatement(sql2);
			preparedStatement2.setString(1, telefoneHospital.getNumerotelefone());
			preparedStatement2.setInt(2, lastId);
			preparedStatement2.execute();
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

	public Hospital buscar(Long id) {
		Hospital hospital = new Hospital();
		try {
			String sql = "select h.nome, h.cnpj, t.numerotelefone, h.rua, h.bairro, , h.cidade " + "from hospital h "
					+ "inner join telefonehospital t ON t.id_hospital = h.idhospital " + "where h.idhospital = ?";

			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setLong(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				hospital.setNome(resultSet.getString("nome"));
				hospital.setCnpj(resultSet.getString("cnpj"));
				hospital.getTelefoneHospital().setNumerotelefone(resultSet.getString("numerotelefone"));
				hospital.setRua(resultSet.getString("rua"));
				hospital.setBairro(resultSet.getString("bairro"));
				hospital.setCidade(resultSet.getString("cidade"));
			}
		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		return hospital;
	}

	public void atualizarHospital(Long id, Hospital hospital, TelefoneHospital telefoneHospital) {
		try {
			String sql = "update hospital set nome= ?, set cnpj= ?, rua= ?, bairro= ?, cidade= ?, where idhospital= ?";
			String sql2 = "update telefonehospital set numerotelefone= ? where id_hospital= ?";

			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			PreparedStatement preparedStatement2 = connection.prepareStatement(sql2);
			preparedStatement.setString(1, hospital.getNome());
			preparedStatement.setString(2, hospital.getCnpj());
			preparedStatement.setString(3, hospital.getRua());
			preparedStatement.setString(4, hospital.getBairro());
			preparedStatement.setString(5, hospital.getCidade());
			preparedStatement.setLong(6, id);

			preparedStatement2.setString(1, telefoneHospital.getNumerotelefone());
			preparedStatement2.setLong(2, id);

			preparedStatement.executeUpdate();
			preparedStatement2.executeUpdate();
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

	public void removerHospital(int id) {

		try {

			String sql = "delete from telefonehospital where id_hospital = ?";
			String sql2 = "delete from hospital where idhospital = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			PreparedStatement preparedStatement2 = connection.prepareStatement(sql2);
			preparedStatement.setInt(1, id);
			preparedStatement2.setInt(1, id);
			preparedStatement.executeUpdate();
			preparedStatement2.executeUpdate();
			connection.commit();
		} catch (Exception e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}

	public ArrayList<Hospital> Listar() {
		ArrayList<Hospital> list = new ArrayList<Hospital>();
		try {
			String sql = "select h.nome, h.cnpj, t.numerotelefone, h.rua, h.bairro, , h.cidade " + "from hospital h "
					+ "inner join telefonehospital t ON t.id_hospital = h.idhospital " + "where h.idhospital = ?";

			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Hospital hospital = new Hospital();
				hospital.setIdhospital(resultSet.getLong("idmedico"));
				hospital.setNome(resultSet.getString("nome"));
				hospital.setCnpj(resultSet.getString("cnpj"));
				hospital.setRua(resultSet.getString("rua"));
				hospital.setBairro(resultSet.getString("bairro"));
				hospital.setCidade(resultSet.getString("cidade"));
				hospital.getTelefoneHospital().setNumerotelefone(resultSet.getString("numerotelefone"));
				list.add(hospital);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

}
