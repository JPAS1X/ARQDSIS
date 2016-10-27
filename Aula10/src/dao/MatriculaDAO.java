package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import factory.ConnectionFactory;
import to.MatriculaTO;

public class MatriculaDAO {
	
	public void incluir(MatriculaTO to) {
		String sqlInsert = "INSERT INTO matricula(valor, data, statusPagamento, statusMatricula, codProfessor, aluno, curso) VALUES (?, ?, ?, ?, ?, ?, ?)";
			// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setString(1, to.getValor());
			stm.setString(2, to.getData());
			stm.setString(3, to.getStatusPagamento());
			stm.setString(4, to.getStatusMatricula());
			stm.setString(5, to.getCodProfessor());
			stm.setString(6, to.getAluno());
			stm.setString(7, to.getCurso());
			stm.execute();
			String sqlSelect = "SELECT LAST_INSERT_ID()";
			try(PreparedStatement stm1 = conn.prepareStatement(sqlSelect);
					ResultSet rs = stm1.executeQuery();){
					if(rs.next()){
						to.setCodigo(rs.getInt(1));
					}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void atualizar(MatriculaTO to) {
		String sqlUpdate = "UPDATE matricula SET valor=?, data=?, statusPagamento=?, statusMatricula=?, codProfessor=?, aluno=?, curso=? WHERE codigo=?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setString(1, to.getValor());
			stm.setString(2, to.getData());
			stm.setString(3, to.getStatusPagamento());
			stm.setString(4, to.getStatusMatricula());
			stm.setString(5, to.getCodProfessor());
			stm.setString(6, to.getAluno());
			stm.setString(7, to.getCurso());
			stm.setInt(8, to.getCodigo());
			
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void excluir(MatriculaTO to) {
		String sqlDelete = "DELETE FROM matricula WHERE codigo = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
			stm.setInt(1, to.getCodigo());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public MatriculaTO carregar(int codigo) {
		MatriculaTO to = new MatriculaTO();
		to.setCodigo(codigo);
		String sqlSelect = "SELECT valor, data, statusPagamento, statusMatricula, codProfessor, aluno, curso FROM matricula WHERE matricula.codigo = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, codigo);
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					to.setValor(rs.getString("valor"));
					to.setData(rs.getString("data"));
					to.setStatusPagamento(rs.getString("statusPagamento"));
					to.setStatusMatricula(rs.getString("statusMatricula"));
					to.setCodProfessor(rs.getString("codProfessor"));
					to.setAluno(rs.getString("aluno"));
					to.setCurso(rs.getString("curso"));
										
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return to;
	}
	
	public ArrayList<MatriculaTO> listarMatricula() {
		MatriculaTO to;
		ArrayList<MatriculaTO> lista = new ArrayList<>();
		String sqlSelect = "SELECT * FROM matricula";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			try (ResultSet rs = stm.executeQuery();) {
				while(rs.next()) {
					to = new MatriculaTO();
					to.setCodigo(rs.getInt("codigo"));
					to.setValor(rs.getString("valor"));
					to.setData(rs.getString("data"));
					to.setStatusPagamento(rs.getString("statusPagamento"));
					to.setStatusMatricula(rs.getString("statusMatricula"));
					to.setCodProfessor(rs.getString("codProfessor"));
					to.setAluno(rs.getString("aluno"));
					to.setCurso(rs.getString("curso"));
					lista.add(to);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return lista;
	}
	
	public ArrayList<MatriculaTO> listarMatriculasCodigo(String chave) {
		MatriculaTO to;
		ArrayList<MatriculaTO> lista = new ArrayList<>();
		String sqlSelect = "SELECT codigo, valor, data, statusPagamento, statusMatricula, codProfessor, aluno, curso  FROM matricula where upper(codigo) like ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
				stm.setString(1, "%" + chave.toUpperCase() + "%");
			try (ResultSet rs = stm.executeQuery();) {
				while(rs.next()) {
					to = new MatriculaTO();
					to.setCodigo(rs.getInt("codigo"));
					to.setValor(rs.getString("valor"));
					to.setData(rs.getString("data"));
					to.setStatusPagamento(rs.getString("statusPagamento"));
					to.setStatusMatricula(rs.getString("statusMatricula"));					
					to.setCodProfessor(rs.getString("codProfessor"));
					to.setAluno(rs.getString("aluno"));
					to.setCurso(rs.getString("curso"));
					lista.add(to);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return lista;
	}

}
