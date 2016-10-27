package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import factory.ConnectionFactory;
import to.InformativoAulaTO;

public class InformativoAulaDAO {
	
	public void incluir(InformativoAulaTO to) {
		String sqlInsert = "INSERT INTO informativoAula( data, nomeProfessor, conteudo) VALUES (?,?,?)";
			// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setString(1,to.getNomeProfessor());
			stm.setString(2,to.getData());
			stm.setString(3,to.getConteudo());			

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

	public void atualizar(InformativoAulaTO to) {
		String sqlUpdate = "UPDATE informativoAula SET data=?, nomeProfessor=?, conteudo=?  WHERE codigo=?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setString(1,to.getNomeProfessor());
			stm.setString(2,to.getData());
			stm.setString(3,to.getConteudo());	
			stm.setInt(4, to.getCodigo());
			
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void excluir(InformativoAulaTO to) {
		String sqlDelete = "DELETE FROM informativoAula WHERE codigo = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
			stm.setInt(1, to.getCodigo());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public InformativoAulaTO carregar(int codigo) {
		InformativoAulaTO to = new InformativoAulaTO();
		to.setCodigo(codigo);
		String sqlSelect = "SELECT data, nomeProfessor, conteudo FROM informativoAula WHERE informativoAula.codigo = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, codigo);
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					to.setData(rs.getString("data"));
					to.setNomeProfessor(rs.getString("nomeProfessor")); 
					to.setConteudo(rs.getString("conteudo"));
					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return to;
	}
	
	public ArrayList<InformativoAulaTO> listarInformativoAula() {
		InformativoAulaTO to;
		ArrayList<InformativoAulaTO> lista = new ArrayList<>();
		String sqlSelect = "SELECT * FROM informativoAula";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			try (ResultSet rs = stm.executeQuery();) {
				while(rs.next()) {
					to = new InformativoAulaTO();
					to.setCodigo(rs.getInt("codigo"));
					to.setData(rs.getString("data"));
					to.setNomeProfessor(rs.getString("nomeProfessor")); 
					to.setConteudo(rs.getString("conteudo"));
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
	
	public ArrayList<InformativoAulaTO> listarInformativoAulaCodigo(String chave) {
		InformativoAulaTO to;
		ArrayList<InformativoAulaTO> lista = new ArrayList<>();
		String sqlSelect = "SELECT codigo, data, nomeProfessor, conteudo FROM informativoAula where upper(codigo) like ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
				stm.setString(1, "%" + chave.toUpperCase() + "%");
			try (ResultSet rs = stm.executeQuery();) {
				while(rs.next()) {
					to = new InformativoAulaTO();
					to.setCodigo(rs.getInt("codigo"));
					to.setData(rs.getString("data"));
					to.setNomeProfessor(rs.getString("nomeProfessor")); 
					to.setConteudo(rs.getString("conteudo"));

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
