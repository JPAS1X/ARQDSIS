package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import factory.ConnectionFactory;
import to.AlunoTO;

public class AlunoDAO {

	public void incluir(AlunoTO to) {
		String sqlInsert = "INSERT INTO aluno (nome, sexo, dataNascimento, endereco, numero, complemento, telefone, email, rg, cpf) VALUES (?,?,?,?,?,?,?,?,?,?)";
		// usando o try with resources do Java 7, que irá executar o fechamento
		// do que abriu

		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setString(1, to.getNome());
			stm.setString(2, to.getSexo());
			stm.setString(3, to.getDataNascimento());
			stm.setString(4, to.getEndereco());
			stm.setInt(5, to.getNumero());
			stm.setString(6, to.getComplemento());
			stm.setString(7, to.getTelefone());
			stm.setString(8, to.getEmail());
			stm.setString(9, to.getRG());
			stm.setString(10, to.getCPF());
			stm.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void atualizar(AlunoTO to) {
		String sqlUpdate = "UPDATE aluno SET nome = ?, sexo = ?, dataNascimento = ?, endereco = ?, numero = ?, complemento = ?, telefone = ?, email = ?, rg = ?, cpf = ? WHERE codigo = ?";
		// usando o try with resources do Java 7, que irá executar o fechamento
		// do que abriu

		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setString(1, to.getNome());
			stm.setString(2, to.getSexo());
			stm.setString(3, to.getDataNascimento());
			stm.setString(4, to.getEndereco());
			stm.setInt(5, to.getNumero());
			stm.setString(6, to.getComplemento());
			stm.setString(7, to.getTelefone());
			stm.setString(8, to.getEmail());
			stm.setString(9, to.getRG());
			stm.setString(10, to.getCPF());
			stm.setInt(11, to.getCodigo());
			stm.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void excluir(AlunoTO to) {
		String sqlDelete = "DELETE FROM aluno WHERE codigo = ?";
		// usando o try with resources do Java 7, que irá executar o fechamento
		// do que abriu

		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
			stm.setInt(1, to.getCodigo());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public AlunoTO carregar(int id) {
		AlunoTO to = new AlunoTO();
		String sqlSelect = "Select * FROM aluno where codigo = ?";
		// usando o try with resources do Java 7, que irá executar o fechamento do que abriu
		
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, id);
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
		            to.setNome(rs.getString("nome"));
		            to.setSexo(rs.getString("sexo"));
		            to.setDataNascimento(rs.getString("dataNascimento"));
		            to.setEndereco(rs.getString("endereco"));
		            to.setNumero(rs.getInt("numero"));
		            to.setComplemento(rs.getString("complemento"));
		            to.setRG(rs.getString("rg"));
		            to.setCPF(rs.getString("cpf"));
		            to.setTelefone(rs.getString("telefone"));
		            to.setEmail(rs.getString("email"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return to;
	}
}
