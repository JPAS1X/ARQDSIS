package model;


import java.util.ArrayList;

import dao.MatriculaDAO;
import to.MatriculaTO;


public class ListarMatricula {
	
	public ArrayList<MatriculaTO> listarMatricula(){
		ArrayList<MatriculaTO> lista;
		MatriculaDAO dao = new MatriculaDAO();
		lista = dao.listarMatricula();
		return lista;
	}

	public ArrayList<MatriculaTO> listarMatriculasCodigo(String chave){
		ArrayList<MatriculaTO> lista;
		MatriculaDAO dao = new MatriculaDAO();
		lista = dao.listarMatriculasCodigo(chave);

		return lista;
	}
}





