package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import factory.ConnectionFactory;
import to.AlunosTO;

public class AlunosDAO extends ConnectionFactory {

	public void cadastrar(AlunosTO to) {

		String sql = "Insert into alunos"
				+ "(nome, rg, cpf, logradouro, email, telefone)" + "values (?,?,?,?,?,?)";

		try {Connection conn = ConnectionFactory.obtemConexao();
		      
		      PreparedStatement pst = conn.prepareStatement(sql);

			pst.setString(1, to.getNome());
			pst.setString(2, to.getRg());
			pst.setInt(3, to.getCpf());
			pst.setString(4, to.getEnd());
			pst.setString(5, to.getEmail());
			pst.setInt(6, to.getTel());
			pst.executeUpdate();
			pst.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		try {

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public AlunosTO consultar (int cpf) {
		
		AlunosTO to = new AlunosTO();

		String sql = "select nome,rg,cpf,logradouro,email,telefone from alunos where cpf=?";

		try {
			Connection conn = ConnectionFactory.obtemConexao();

			PreparedStatement pst = conn.prepareStatement(sql);

			pst.setInt(1, to.getCpf());

			ResultSet rs = pst.executeQuery();

			if (rs.next()) {

				to.setNome(rs.getString("nome"));
				to.setRg(rs.getString("rg"));
				to.setCpf(rs.getInt("cpf"));
				to.setEnd(rs.getString("logradouro"));
				to.setEmail(rs.getString("email"));
				to.setTel(rs.getInt("telefone"));

			}

			pst.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		try {

		} catch (Exception e) {
			e.printStackTrace();
		}

		return to;

	}

	public void alterar(AlunosTO to) {

		String sql = "update alunos set nome=?,rg=?, logradouro=? , email=?, telefone=? where cpf=?";

		try {
			
			Connection conn = ConnectionFactory.obtemConexao();

			PreparedStatement pst = conn.prepareStatement(sql);

			pst.setString(1, to.getNome());
			pst.setString(2, to.getRg());
			pst.setString(3, to.getEnd());
			pst.setString(4, to.getEmail());
			pst.setInt(5, to.getTel());
			pst.setInt(6, to.getCpf());
			pst.executeUpdate();
			pst.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		try {

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void deletar(AlunosTO to) {

		String sql = "delete from alunos where cpf=?";

		try {
			
			Connection conn = ConnectionFactory.obtemConexao();

			PreparedStatement pst = conn.prepareStatement(sql);

			pst.setInt(1, to.getCpf());
			pst.executeUpdate();
			pst.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		try {

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
