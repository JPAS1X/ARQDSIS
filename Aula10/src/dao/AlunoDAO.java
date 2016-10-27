package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import factory.ConnectionFactory;
import to.AlunoTO;

public class AlunoDAO {
	
	public void incluir(AlunoTO to) {
		String sqlInsert = "INSERT INTO aluno(nome, nomeM, rg, endereco, foneF, fone, email, codProfessor, usuario, senha, permissao) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setString(1, to.getNome());
			stm.setString(2, to.getFone());
			stm.setString(3, to.getFoneF());
			stm.setString(4, to.getNomeM());
			stm.setString(5, to.getRg());
			stm.setString(6, to.getEndereco());
			stm.setString(7, to.getEmail());
			stm.setString(8, to.getCodProfessor());
			stm.setString(9, to.getUsuario());
			stm.setString(10, to.getSenha());
			stm.setString(11, to.getPermissao());
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

	public void atualizar(AlunoTO to) {
		String sqlUpdate = "UPDATE aluno SET nome=?, nomeM=?, rg=?, endereco=?, foneF=?, fone=?, email=?, codProfessor=?, usuario=?, senha=?, permissao=? WHERE id=?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setString(1, to.getNome());
			stm.setString(2, to.getFone());
			stm.setString(3, to.getFoneF());
			stm.setString(4, to.getNomeM());
			stm.setString(5, to.getRg());
			stm.setString(6, to.getEndereco());
			stm.setString(7, to.getEmail());
			stm.setString(8, to.getCodProfessor());
			stm.setString(9, to.getUsuario());
			stm.setString(10, to.getSenha());
			stm.setString(11, to.getPermissao());
			stm.setInt(12, to.getId());
			
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void excluir(AlunoTO to) {
		String sqlDelete = "DELETE FROM aluno WHERE id = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
			stm.setInt(1, to.getId());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public AlunoTO carregar(int id) {
		AlunoTO to = new AlunoTO();
		to.setId(id);
		String sqlSelect = "SELECT nome, nomeM, rg, endereco, foneF, fone, email, codProfessor, usuario, senha, permissao FROM aluno WHERE aluno.id = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, id);
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					to.setNome(rs.getString("nome"));
					to.setNomeM(rs.getString("nomeM"));
					to.setRg(rs.getString("rg"));
					to.setEndereco(rs.getString("endereco"));
					to.setFoneF(rs.getString("foneF"));
					to.setFone(rs.getString("fone"));
					to.setEmail(rs.getString("email"));
					to.setCodProfessor(rs.getString("codProfessor"));
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
	
	public ArrayList<AlunoTO> listarAlunos() {
		AlunoTO to;
		ArrayList<AlunoTO> lista = new ArrayList<>();
		String sqlSelect = "SELECT id, nome, nomeM, rg, endereco, foneF, fone, email, codProfessor, usuario, senha, permissao FROM aluno";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			try (ResultSet rs = stm.executeQuery();) {
				while(rs.next()) {
					to = new AlunoTO();
					to.setId(rs.getInt("id"));
					to.setNome(rs.getString("nome"));
					to.setNomeM(rs.getString("nomeM"));
					to.setRg(rs.getString("rg"));
					to.setEndereco(rs.getString("endereco"));
					to.setFoneF(rs.getString("foneF"));
					to.setFone(rs.getString("fone"));
					to.setEmail(rs.getString("email"));
					to.setCodProfessor(rs.getString("codProfessor"));
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
	
	public ArrayList<AlunoTO> listarAlunosRG(String chave) {
		AlunoTO to;
		ArrayList<AlunoTO> lista = new ArrayList<>();
		String sqlSelect = "SELECT id, nome, nomeM, rg, endereco, foneF, fone, email, codProfessor, usuario, senha, permissao FROM aluno where upper(rg) like ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
				stm.setString(1, "%" + chave.toUpperCase() + "%");
			try (ResultSet rs = stm.executeQuery();) {
				while(rs.next()) {
					to = new AlunoTO();
					to.setId(rs.getInt("id"));
					to.setNome(rs.getString("nome"));
					to.setNomeM(rs.getString("nomeM"));
					to.setRg(rs.getString("rg"));
					to.setEndereco(rs.getString("endereco"));
					to.setFoneF(rs.getString("foneF"));
					to.setFone(rs.getString("fone"));
					to.setEmail(rs.getString("email"));
					to.setCodProfessor(rs.getString("codProfessor"));
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
