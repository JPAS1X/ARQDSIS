package dao;
import java.sql.*;

import factory.ConnectionFactory;
import to.CursosTO;

public class CursosDAO extends ConnectionFactory {

	public void cadastrar(CursosTO to) {
		
		

		String sql = "Insert into cursos"
				+ "(codigo, curso, data_inicio, data_termino, horario, vagas, valor, numero_laboratorio, registro_software, material, livros)"
				+ "values (?,?,?,?,?,?,?,?,?,?,?)";

		try {
  
			Connection conn = ConnectionFactory.obtemConexao();
			
			PreparedStatement pst = conn.prepareStatement(sql);

			pst.setString(1,to.getCod());
			pst.setString(2,to.getNome());
			pst.setString(3,to.getDataIni());
			pst.setString(4,to.getDataTer());
			pst.setString(5,to.getHorario());
			pst.setInt(6, to.getVagas());
			pst.setDouble(7,to.getValor());
			pst.setString(8, to.getNumLab());
			pst.setString(9,to.getRegSoft());
			pst.setString(10,to.getMaterial());
			pst.setString(11,to.getLivro());
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

	public CursosTO consultar(String cod) {
		
		CursosTO to = new CursosTO();

		String sql = "select codigo, curso, data_inicio, data_termino, horario, vagas, valor, numero_laboratorio, registro_software, material, livros from cursos where codigo = ?";

		try {
			
			Connection conn = ConnectionFactory.obtemConexao();

			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, to.getCod());

			ResultSet rs = pst.executeQuery();

			if (rs.next()) {

				to.setCod(rs.getString("codigo"));
				to.setNome(rs.getString("curso"));
				to.setDataIni(rs.getString("data_inicio"));
				to.setDataTer(rs.getString("data_termino"));
				to.setHorario(rs.getString("horario"));
				to.setVagas(rs.getInt("vagas"));
				to.setValor(rs.getDouble("valor"));
				to.setNumLab(rs.getString("numero_laboratorio"));
				to.setRegSoft(rs.getString("registro_software"));
				to.setMaterial(rs.getString("material"));
				to.setLivro(rs.getString("livros"));

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

	public void alterar(CursosTO to) {

		
		String sql = "update cursos set curso=?, data_inicio=?, data_termino=?, horario=?, vagas=?, valor=?, numero_laboratorio=?, registro_software=?, material=?, livros=? where codigo=?";

		try {
			Connection conn = ConnectionFactory.obtemConexao();
			
			PreparedStatement pst = conn.prepareStatement(sql);

			pst.setString(1, to.getNome());
			pst.setString(2, to.getDataIni());
			pst.setString(3, to.getDataTer());
			pst.setString(4, to.getHorario());
			pst.setInt(5, to.getVagas());
			pst.setDouble(6, to.getValor());
			pst.setString(7, to.getNumLab());
			pst.setString(8, to.getRegSoft());
			pst.setString(9, to.getMaterial());
			pst.setString(10, to.getLivro());
			pst.setString(11, to.getCod());
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

	public void deletar(CursosTO to) {

		
		String sql = "delete from cursos where codigo=?";

		try {
              
			Connection conn = ConnectionFactory.obtemConexao();
			
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, to.getCod());
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
