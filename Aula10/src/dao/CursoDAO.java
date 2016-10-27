package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import factory.ConnectionFactory;
import to.CursoTO;


public class CursoDAO  {
	
	protected String tipo, nome, dataInicio, dataTermino, horario, numeroVagas, valor, disponibilidade;  
	protected int selecionado, codigo;
	protected ArrayList<String> dadosConsult = new ArrayList<String> ();
	public ArrayList<String> buscaTodos = new ArrayList<String> ();
	//	protected ResourceBundle bn = null;  
	public CursoTO infoConsulta=null;

	
	
	public ArrayList<CursoTO> listarCurso() {
		CursoTO to;
		ArrayList<CursoTO> lista = new ArrayList<>();
		String sqlSelect = "select * from curso"; 
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			try (ResultSet rs = stm.executeQuery();) {
				while(rs.next()) {
					to = new CursoTO();
					
					to.setCodigo(rs.getInt("codigo"));
					to.setTipo(rs.getString(2));
					to.setNome(rs.getString(3)); // o resultset pega o conteudo da descricao e coloca em uma variavel p exibir
					to.setDataInicio(rs.getString(4));
					to.setDataTermino(rs.getString(5));
					to.setHorario(rs.getString(6));
					to.setNumeroVagas(rs.getString(7));
					to.setValor(rs.getString(8));
					to.setDisponibilidade(rs.getString(9));      
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
	
	public ArrayList<CursoTO> listarCurso(String chave) {
		CursoTO to;
		ArrayList<CursoTO> lista = new ArrayList<>();
		String sqlSelect = "SELECT codigo, tipo, nome, dataInicio, dataTermino, horario, numeroVagas, valor, disponibilidade  FROM curso where upper(nome) like ?";
		
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
				stm.setString(1, "%" + chave.toUpperCase() + "%");
			try (ResultSet rs = stm.executeQuery();) {
				while(rs.next()) {
				
					to = new CursoTO();
					
					to.setCodigo(rs.getInt("codigo"));
					to.setTipo(rs.getString(2));
					to.setNome(rs.getString(3)); // o resultset pega o conteudo da descricao e coloca em uma variavel p exibir
					to.setDataInicio(rs.getString(4));
					to.setDataTermino(rs.getString(5));
					to.setHorario(rs.getString(6));
					to.setNumeroVagas(rs.getString(7));
					to.setValor(rs.getString(8));
					to.setDisponibilidade(rs.getString(9));      
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
	
	//INSERIR	
	public void inserir(CursoTO infoTO){ 

		String sqlInsert = "INSERT INTO curso (tipo, nome, dataInicio, dataTermino, horario, numeroVagas, valor, disponibilidade)  VALUES (?,?,?,?,?,?,?,?)";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement pst = conn.prepareStatement(sqlInsert);) {

			pst.setString(1,infoTO.getTipo());
			pst.setString(2,infoTO.getNome());
			pst.setString(3,infoTO.getDataInicio());
			pst.setString(4,infoTO.getDataTermino());
			pst.setString(5,infoTO.getHorario());
			pst.setString(6,infoTO.getNumeroVagas());
			pst.setString(7,infoTO.getValor());
			pst.setString(8,infoTO.getDisponibilidade());
			pst.execute();
			String sqlSelect = "SELECT LAST_INSERT_ID()";
			try(PreparedStatement pst1 = conn.prepareStatement(sqlSelect);
					ResultSet rs = pst1.executeQuery();){
					if(rs.next()){
						infoTO.setCodigo(rs.getInt(1));
					}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	

	// DELETAR UM CURSO
	public void deletar(CursoTO infoTO){

		//	Connection conn = getConnection();

		String sqlDelete = "delete from curso where codigo=?";

		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement pst = conn.prepareStatement(sqlDelete);) {
			pst.setInt(1,infoTO.getCodigo());
			pst.executeUpdate();
			} 
			catch(Exception e) {
				  e.printStackTrace();
			}    
		}



	// ALTERA
	public void alterar(CursoTO infoTO){ 
		codigo = infoTO.getCodigo();
		String sqlUpdate = "update curso set tipo=?, nome=?, dataInicio=?, dataTermino=?, horario=?, numeroVagas=?, valor=?, disponibilidade=? where codigo=?";  

		try (Connection conn = ConnectionFactory.obtemConexao();
			PreparedStatement pst = conn.prepareStatement(sqlUpdate);) {
			pst.setString(1,infoTO.getTipo());
			pst.setString(2,infoTO.getNome());
			pst.setString(3,infoTO.getDataInicio());
			pst.setString(4,infoTO.getDataTermino());
			pst.setString(5,infoTO.getHorario());
			pst.setString(6,infoTO.getNumeroVagas());
			pst.setString(7,infoTO.getValor());
			pst.setString(8,infoTO.getDisponibilidade());
			pst.setInt(9,infoTO.getCodigo());
			pst.execute();

		} 
		catch(Exception e) {
			e.printStackTrace();
		}
	}


	//id == codigo
	public CursoTO carregar(CursoTO infoTO) {
		CursoTO too = new CursoTO();
		too.setCodigo(infoTO.getCodigo());
		codigo = infoTO.getCodigo();
		String sqlSelect = "SELECT tipo, nome, dataInicio, dataTermino, horario, numeroVagas, valor, disponibilidade  FROM curso where codigo=?";
		
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, codigo);
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {					
					too.setTipo(rs.getString(1));
					too.setNome(rs.getString(2)); 
					too.setDataInicio(rs.getString(3));
					too.setDataTermino(rs.getString(4));
					too.setHorario(rs.getString(5));
					too.setNumeroVagas(rs.getString(6));
					too.setValor(rs.getString(7));          
					too.setDisponibilidade(rs.getString(8));      
					
		
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return too;
	}
	
	public CursoTO carregar2(int id) {
		CursoTO too = new CursoTO();
		too.setCodigo(id);
		String sqlSelect = "SELECT tipo, nome, dataInicio, dataTermino, horario, numeroVagas, valor, disponibilidade  FROM curso where codigo=?";
		
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, codigo);
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {					
					too.setTipo(rs.getString(1));
					too.setNome(rs.getString(2)); 
					too.setDataInicio(rs.getString(3));
					too.setDataTermino(rs.getString(4));
					too.setHorario(rs.getString(5));
					too.setNumeroVagas(rs.getString(6));
					too.setValor(rs.getString(7));          
					too.setDisponibilidade(rs.getString(8));      
					
		
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return too;
	}
	
	
	public CursoTO consultar(CursoTO infoTO){
		
		
		String sql = "select * from curso where codigo=?"; 
		 CursoTO to = new CursoTO();

			try (Connection conn = ConnectionFactory.obtemConexao();
					PreparedStatement pst = conn.prepareStatement(sql);) {
		
		   	pst.setInt(1, to.getCodigo());
			ResultSet rs = pst.executeQuery(); 

			if (rs.next()) {
				to.setCodigo(rs.getInt(1));
				to.setTipo(rs.getString(2)); 
				to.setNome(rs.getString(3));
				to.setDataInicio(rs.getString(4));
				to.setDataTermino(rs.getString(5));
				to.setHorario(rs.getString(6));
				to.setNumeroVagas(rs.getString(7));
				to.setValor(rs.getString(8));
				to.setDisponibilidade(rs.getString(9));      
				
				infoConsulta = to;
				//AlunoDAOTest test = new AlunoDAOTest();
				//test.Busca(alunoCpfTO);
				
				
				
			}
			pst.close();   
			if(infoTO.getCodigo() == (to.getCodigo())){
			
				return to;
			}
			else { 
				JOptionPane.showMessageDialog(null, ("erroAleatorio") , ("msgErro"), JOptionPane.ERROR_MESSAGE); 
			}
		}       

		catch(Exception e) {
			e.printStackTrace();            
			JOptionPane.showMessageDialog(null, ("cpfInexistente"), ("msgErro"), JOptionPane.ERROR_MESSAGE); 

		}
		return to;
	}
	
	
}

