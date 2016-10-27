package model;

import java.util.ArrayList;

import dao.CursoDAO;
import to.CursoTO;

public class ListarCurso {


	public ArrayList<CursoTO> listarCurso(){
		ArrayList<CursoTO> lista;
		CursoDAO dao = new CursoDAO();
		lista = dao.listarCurso();
		return lista;
	}

	public ArrayList<CursoTO> listarCurso(String chave){
		ArrayList<CursoTO> lista;
		CursoDAO dao = new CursoDAO();
		lista = dao.listarCurso(chave);
		return lista;
	}
}
