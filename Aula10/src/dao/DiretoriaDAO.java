package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import factory.ConnectionFactory;
import to.DiretoriaTO;

public class DiretoriaDAO {
	
	public void incluir(DiretoriaTO to) {
		String sqlInsert = "INSERT INTO diretoria(nome, rg, unidade, foneF, fone, email, usuario, senha, permissao) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
			// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setString(1, to.getNome());
			stm.setString(2, to.getRg());
			stm.setString(3, to.getFoneF());
			stm.setString(4, to.getFone());
			stm.setString(5, to.getUnidade());
			stm.setString(6, to.getEmail());
			stm.setString(7, to.getUsuario());
			stm.setString(8, to.getSenha());
			stm.setString(9, to.getPermissao());
			stm.execute();
			String sqlSelect = "SELECT LAST_INSERT_ID()";
			try(PreparedStatement stm1 = conn.prepareStatement(sqlSelect);
					ResultSet rs = stm1.executeQuery();){
					if(rs.next()){
						to.setId(rs.getInt(1));
					}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void atualizar(DiretoriaTO to) {
		String sqlUpdate = "UPDATE diretoria SET nome=?, rg=?, unidade=?, foneF, fone=?, email=?, usuario=?, senha=?, permissao=? WHERE id=?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setString(1, to.getNome());
			stm.setString(2, to.getFone());
			stm.setString(3, to.getFoneF());
			stm.setString(5, to.getRg());
			stm.setString(6, to.getUnidade());
			stm.setString(7, to.getEmail());
			stm.setString(8, to.getUsuario());
			stm.setString(9, to.getSenha());
			stm.setString(10, to.getPermissao());
			stm.setInt(11, to.getId());
			
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void excluir(DiretoriaTO to) {
		String sqlDelete = "DELETE FROM diretoria WHERE id = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
			stm.setInt(1, to.getId());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public DiretoriaTO carregar(int id) {
		DiretoriaTO to = new DiretoriaTO();
		to.setId(id);
		String sqlSelect = "SELECT nome, rg, unidade, foneF, fone, email, usuario, senha, permissao FROM diretoria WHERE diretoria.id = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, id);
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					to.setNome(rs.getString("nome"));
					to.setRg(rs.getString("rg"));
					to.setUnidade(rs.getString("unidade"));
					to.setFoneF(rs.getString("foneF"));
					to.setFone(rs.getString("fone"));
					to.setEmail(rs.getString("email"));
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
	
	public ArrayList<DiretoriaTO> listarDiretoria() {
		DiretoriaTO to;
		ArrayList<DiretoriaTO> lista = new ArrayList<>();
		String sqlSelect = "SELECT id, nome, rg, unidade, foneF, fone, email, usuario, senha, permissao FROM diretoria";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			try (ResultSet rs = stm.executeQuery();) {
				while(rs.next()) {
					to = new DiretoriaTO();
					to.setId(rs.getInt("id"));
					to.setNome(rs.getString("nome"));
					to.setRg(rs.getString("rg"));
					to.setUnidade(rs.getString("unidade"));
					to.setFoneF(rs.getString("foneF"));
					to.setFone(rs.getString("fone"));
					to.setEmail(rs.getString("email"));
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
	
	public ArrayList<DiretoriaTO> listarDiretoriaRG(String chave) {
		DiretoriaTO to;
		ArrayList<DiretoriaTO> lista = new ArrayList<>();
		String sqlSelect = "SELECT id, nome, rg, unidade, foneF, fone, email, usuario, senha, permissao FROM diretoria where upper(rg) like ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
				stm.setString(1, "%" + chave.toUpperCase() + "%");
			try (ResultSet rs = stm.executeQuery();) {
				while(rs.next()) {
					to = new DiretoriaTO();
					to.setId(rs.getInt("id"));
					to.setNome(rs.getString("nome"));
					to.setRg(rs.getString("rg"));
					to.setUnidade(rs.getString("unidade"));
					to.setFoneF(rs.getString("foneF"));
					to.setFone(rs.getString("fone"));
					to.setEmail(rs.getString("email"));
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
