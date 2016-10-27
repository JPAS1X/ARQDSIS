package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import to.CursoTO;
import factory.ConnectionFactory;

public class CursoDAO {
	
	   public void incluir(CursoTO to)
	   {              
	      String sqlInsert = "INSERT Into curso (nome, tipo, dataDeInicio, dataDeTermino, horario, valor, numeroDeVagas, tipoLab, softwares, livros, descricaoMaterial) values (?,?,?,?,?,?,?,?,?,?,?)";
	      
	      try (Connection conn = ConnectionFactory.obtemConexao();
	  		PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			    stm.setString(1, to.getNome());
			    stm.setString(2, to.getTipo());
			    stm.setString(3, to.getDataDeInicio());
			    stm.setString(4, to.getDataDeTermino());
			    stm.setString(5, to.getHorario());
			    stm.setDouble(6, to.getValor());
			    stm.setInt(7, to.getNumeroDeVagas());
			    stm.setString(8, to.getTipoLab());
			    stm.setString(9, to.getSoftwares());
			    stm.setString(10, to.getLivros());
			    stm.setString(11, to.getDescricao());
			    stm.executeUpdate();
	      }catch(SQLException e){
	         e.printStackTrace();
	      }
	
	   }

	   public void atualizar(CursoTO to)
	   {
	      String sqlUpdate = "UPDATE Into curso (nome, tipo, dataDeInicio, dataDeTermino, horario, valor, numeroDeVagas, tipoLab, softwares, livros, descricaoMaterial) values (?,?,?,?,?,?,?,?,?,?,?) ";
	   
	      try (Connection conn = ConnectionFactory.obtemConexao();
			PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
					stm.setString(1, to.getNome());
				    stm.setString(2, to.getTipo());
				    stm.setString(3, to.getDataDeInicio());
				    stm.setString(4, to.getDataDeTermino());
				    stm.setString(5, to.getHorario());
				    stm.setDouble(6, to.getValor());
				    stm.setInt(7, to.getNumeroDeVagas());
				    stm.setString(8, to.getTipoLab());
				    stm.setString(9, to.getSoftwares());
				    stm.setString(10, to.getLivros());
				    stm.setString(11, to.getDescricao());
				    stm.executeUpdate();
	      }catch(Exception e){
	         e.printStackTrace();
	         
	      }
	   }
	   
	   public void excluir(CursoTO to) {
			String sqlDelete = "DELETE FROM curso WHERE codigo = ?";
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
	   
	   public CursoTO carregar(int id) {
		   CursoTO to = new CursoTO();
			String sqlSelect = "Select * from curso where codigo = ?";
			// usando o try with resources do Java 7, que irá executar o fechamento
			// do que abriu
			
			try (Connection conn = ConnectionFactory.obtemConexao();
					PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
				stm.setInt(1, id);
				try (ResultSet rs = stm.executeQuery();) {
					if (rs.next()) {
			            to.setNome(rs.getString("nome"));
			            to.setTipo(rs.getString("tipo"));
			            to.setDataDeInicio(rs.getString("dataDeInicio"));
			            to.setDataDeTermino(rs.getString("dataDeTermino"));
			            to.setHorario(rs.getString("horario"));
			            to.setNumeroDeVagas(rs.getInt("numeroDeVagas"));
			            to.setValor(rs.getDouble("valor"));
			            to.setTipoLab(rs.getString("tipoLab"));
			            to.setSoftwares(rs.getString("softwares"));
			            to.setLivros(rs.getString("livros"));
			            to.setDescricao(rs.getString("descricaoMaterial"));
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
