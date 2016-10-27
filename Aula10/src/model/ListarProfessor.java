package model;

import java.util.ArrayList;

import dao.ProfessorDAO;
import to.ProfessorTO;

public class ListarProfessor {


	public ArrayList<ProfessorTO> listarProfessor(){
		ArrayList<ProfessorTO> lista;
		ProfessorDAO dao = new ProfessorDAO();
		lista = dao.listarProfessor();
		return lista;
	}

	public ArrayList<ProfessorTO> listarProfessorRG(String chave){
		ArrayList<ProfessorTO> lista;
		ProfessorDAO dao = new ProfessorDAO();
		lista = dao.listarProfessorRG(chave);
		return lista;
	}
}
