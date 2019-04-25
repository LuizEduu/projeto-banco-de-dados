package dao;

import org.hibernate.HibernateException;
import org.hibernate.Transaction;

import model.EnderecoPaciente;
import model.Paciente;
import model.TelefonePaciente;

public class PacienteDao {

	/*
	 * private Connection connection;
	 * 
	 * public PacienteDao() { this.connection = SingeConnection.getConnection(); }
	 * 
	 */
	public void Salvar(Paciente paciente, TelefonePaciente telefonePaciente, EnderecoPaciente enderecoPaciente) {
		try {

			org.hibernate.Session session = config.HibernateUtil.getSessionFactory().openSession();
			Transaction transaction = null;
			try {
				transaction = session.beginTransaction();
				session.save(paciente);
				session.save(telefonePaciente);
				session.save(enderecoPaciente);
				transaction.commit();
			} catch (HibernateException e) {
				transaction.rollback();
				e.printStackTrace();
			} finally {
				session.close();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * public Paciente buscar(int id) { Paciente paciente = new Paciente(); try {
	 * String sql =
	 * "select p.nome, p.sexo, p.email, t.numerotelefone, e.rua, e.numero, e.bairro, e.cidade, p.nascimento "
	 * + "from paciente p " +
	 * "inner join telefonepaciente t ON t.idtelefonepaciente = p.idpaciente " +
	 * "inner join enderecopaciente e ON e.idenderecopaciente = p.idpaciente " +
	 * "where idpaciente =?";
	 * 
	 * PreparedStatement preparedStatement = connection.prepareStatement(sql);
	 * preparedStatement.setInt(1, id); ResultSet resultSet =
	 * preparedStatement.executeQuery();
	 * 
	 * while (resultSet.next()) { paciente.setNome(resultSet.getString("nome"));
	 * paciente.setSexo(resultSet.getString("sexo"));
	 * paciente.setEmail(resultSet.getString("email"));
	 * paciente.setTelefone(resultSet.getString("numerotelefone"));
	 * paciente.setRua(resultSet.getString("rua"));
	 * paciente.setNumero(resultSet.getString("numero"));
	 * paciente.setBairro(resultSet.getString("bairro"));
	 * paciente.setCidade(resultSet.getString("cidade"));
	 * paciente.setNascimento(resultSet.getString("nascimento")); } } catch
	 * (SQLException e) { try { connection.rollback(); } catch (SQLException e1) {
	 * e1.printStackTrace(); } e.printStackTrace(); }
	 * 
	 * return paciente; }
	 * 
	 * public void atualizarpaciente(int id, Paciente paciente) { try { String sql =
	 * "update paciente set nome=?, sexo=?, email=?,nascimento=? where idpaciente=?"
	 * ; String sql2 =
	 * "update telefonepaciente set numerotelefone=? where idtelefonepaciente=?";
	 * String sql3 =
	 * "update enderecopaciente set rua=?, numero=?, bairro=?, cidade=? where idenderecopaciente=?"
	 * ; PreparedStatement preparedStatement = connection.prepareStatement(sql);
	 * PreparedStatement preparedStatement2 = connection.prepareStatement(sql2);
	 * PreparedStatement preparedStatement3 = connection.prepareStatement(sql3);
	 * 
	 * preparedStatement.setString(1, paciente.getNome());
	 * preparedStatement.setString(2, paciente.getSexo());
	 * preparedStatement.setString(3, paciente.getEmail());
	 * preparedStatement.setString(4, paciente.getNascimento());
	 * preparedStatement.setInt(5, id); preparedStatement2.setString(1,
	 * paciente.getTelefone()); preparedStatement2.setInt(2, id);
	 * preparedStatement3.setString(1, paciente.getRua());
	 * preparedStatement3.setString(2, paciente.getNumero());
	 * preparedStatement3.setString(3, paciente.getBairro());
	 * preparedStatement3.setString(4, paciente.getCidade());
	 * preparedStatement3.setInt(5, id);
	 * 
	 * preparedStatement.executeUpdate(); preparedStatement2.executeUpdate();
	 * preparedStatement3.executeUpdate(); connection.commit();
	 * 
	 * } catch (SQLException e) { try { connection.rollback(); } catch (SQLException
	 * e1) { e1.printStackTrace(); } e.printStackTrace(); }
	 * 
	 * try { connection.close(); } catch (SQLException e) { e.printStackTrace(); } }
	 * 
	 * public void removerpaciente(int id) {
	 * 
	 * try { String sql = "delete from paciente where idpaciente = ?"; String sql2 =
	 * "delete from telefonepaciente where idtelefone = ?"; String sql3 =
	 * "delete from enderecopaciente where idendereco = ?"; PreparedStatement
	 * preparedStatement = connection.prepareStatement(sql); PreparedStatement
	 * preparedStatement2 = connection.prepareStatement(sql2); PreparedStatement
	 * preparedStatement3 = connection.prepareStatement(sql3);
	 * preparedStatement.setInt(1, id); preparedStatement2.setInt(1, id);
	 * preparedStatement3.setInt(1, id); preparedStatement.executeUpdate();
	 * preparedStatement2.executeUpdate(); preparedStatement3.executeUpdate();
	 * connection.commit(); connection.close(); } catch (Exception e) { try {
	 * connection.rollback(); } catch (SQLException e1) { e1.printStackTrace(); } }
	 * }
	 * 
	 * public ArrayList<Paciente> Listar() { ArrayList<Paciente> list = new
	 * ArrayList<Paciente>(); try { String sql =
	 * "select p.idpaciente, p.nome, p.sexo, p.email, t.numerotelefone, e.rua, e.numero, e.bairro, e.cidade, p.nascimento "
	 * + "from paciente p " +
	 * "inner join telefonepaciente t ON t.idtelefonepaciente = p.idpaciente " +
	 * "inner join enderecopaciente e ON e.idenderecopaciente = p.idpaciente";
	 * 
	 * PreparedStatement preparedStatement = connection.prepareStatement(sql);
	 * ResultSet resultSet = preparedStatement.executeQuery();
	 * 
	 * while (resultSet.next()) { Paciente paciente = new Paciente();
	 * paciente.setId(resultSet.getInt("idpaciente"));
	 * paciente.setNome(resultSet.getString("nome"));
	 * paciente.setSexo(resultSet.getString("sexo"));
	 * paciente.setEmail(resultSet.getString("email"));
	 * paciente.setTelefone(resultSet.getString("numerotelefone"));
	 * paciente.setRua(resultSet.getString("rua"));
	 * paciente.setNumero(resultSet.getString("numero"));
	 * paciente.setBairro(resultSet.getString("bairro"));
	 * paciente.setCidade(resultSet.getString("cidade"));
	 * paciente.setNascimento(resultSet.getString("nascimento"));
	 * list.add(paciente); }
	 * 
	 * } catch (Exception e) { e.printStackTrace(); }
	 * 
	 * return list; }
	 * 
	 */

}
