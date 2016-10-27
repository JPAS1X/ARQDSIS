package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import factory.ConnectionFactory;
import to.ProfessorTO;

public class ProfessorDAO {
	
	public void incluir(ProfessorTO to) {
		String sqlInsert = "INSERT INTO professor( nome, rg, dataAdm, telefone, celular, email, curso, usuario, senha, permissao) VALUES (?,?,?,?,?,?,?,?,?,?)";
			// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setString(1,to.getNome());
			stm.setString(2,to.getRg());
			stm.setString(3,to.getDataAdm());
			stm.setString(4,to.getTelefone());
			stm.setString(5,to.getCelular());
			stm.setString(6,to.getEmail());
			stm.setString(7,to.getCurso());
			stm.setString(8,to.getUsuario());
			stm.setString(9,to.getSenha());
			stm.setString(10,to.getPermissao());

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

	public void atualizar(ProfessorTO to) {
		String sqlUpdate = "UPDATE professor SET nome=?, rg=?, dataAdm=?, telefone=?, celular=?, email=?, curso=?, usuario=?, senha=?, permissao=?  WHERE codigo=?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setString(1,to.getNome());
			stm.setString(2,to.getRg());
			stm.setString(3,to.getDataAdm());
			stm.setString(4,to.getTelefone());
			stm.setString(5,to.getCelular());
			stm.setString(6,to.getEmail());
			stm.setString(7,to.getCurso());
			stm.setInt(8,to.getCodigo());
			stm.setString(8,to.getUsuario());
			stm.setString(9,to.getSenha());
			stm.setString(10,to.getPermissao());
			stm.setInt(11, to.getCodigo());
			
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void excluir(ProfessorTO to) {
		String sqlDelete = "DELETE FROM professor WHERE codigo = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
			stm.setInt(1, to.getCodigo());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ProfessorTO carregar(int codigo) {
		ProfessorTO to = new ProfessorTO();
		to.setCodigo(codigo);
		String sqlSelect = "SELECT nome, rg, dataAdm, telefone, celular, email, curso, usuario, senha, permissao FROM professor WHERE professor.codigo = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, codigo);
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					to.setNome(rs.getString("nome")); 
					to.setRg(rs.getString("rg"));
					to.setDataAdm(rs.getString("dataAdm"));
					to.setTelefone(rs.getString("telefone"));
					to.setCelular(rs.getString("celular"));
					to.setEmail(rs.getString("email"));          
					to.setCurso(rs.getString("curso")); 
					to.setUsuario(rs.getString("usuario"));
					to.setSenha(rs.getString("senha"));          
					to.setPermissao(rs.getString("permissao"));

				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return to;
	}
	
	public ArrayList<ProfessorTO> listarProfessor() {
		ProfessorTO to;
		ArrayList<ProfessorTO> lista = new ArrayList<>();
		String sqlSelect = "SELECT * FROM professor";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			try (ResultSet rs = stm.executeQuery();) {
				while(rs.next()) {
					to = new ProfessorTO();
					to.setCodigo(rs.getInt("codigo"));
					to.setNome(rs.getString("nome")); 
					to.setRg(rs.getString("rg"));
					to.setDataAdm(rs.getString("dataAdm"));
					to.setTelefone(rs.getString("telefone"));
					to.setCelular(rs.getString("celular"));
					to.setEmail(rs.getString("email"));          
					to.setCurso(rs.getString("curso")); 
					to.setUsuario(rs.getString("usuario"));
					to.setSenha(rs.getString("senha"));          
					to.setPermissao(rs.getString("permissao"));
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
	
	public ArrayList<ProfessorTO> listarProfessorRG(String chave) {
		ProfessorTO to;
		ArrayList<ProfessorTO> lista = new ArrayList<>();
		String sqlSelect = "SELECT codigo, nome, rg, dataAdm, telefone, celular, email, curso, usuario, senha, permissao FROM professor where upper(rg) like ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
				stm.setString(1, "%" + chave.toUpperCase() + "%");
			try (ResultSet rs = stm.executeQuery();) {
				while(rs.next()) {
					to = new ProfessorTO();
					to.setCodigo(rs.getInt("codigo"));
					to.setNome(rs.getString("nome")); 
					to.setRg(rs.getString("rg"));
					to.setDataAdm(rs.getString("dataAdm"));
					to.setTelefone(rs.getString("telefone"));
					to.setCelular(rs.getString("celular"));
					to.setEmail(rs.getString("email"));          
					to.setCurso(rs.getString("curso")); 
					to.setUsuario(rs.getString("usuario"));
					to.setSenha(rs.getString("senha"));          
					to.setPermissao(rs.getString("permissao"));

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
