package model;

import java.util.ArrayList;

import dao.AlunoDAO;
import dao.DiretoriaDAO;
import dao.ProfessorDAO;
import to.AlunoTO;
import to.DiretoriaTO;
import to.ProfessorTO;

public class Vendedor {
	public ArrayList<AlunoTO> listarAlunos(){
		ArrayList<AlunoTO> lista;
		AlunoDAO dao = new AlunoDAO();
		lista = dao.listarAlunos();
		return lista;
	}
	public ArrayList<AlunoTO> listarAlunos(String chave){
		ArrayList<AlunoTO> lista;
		AlunoDAO dao = new AlunoDAO();
		lista = dao.listarAlunosRG(chave);
		return lista;
	}

	public ArrayList<DiretoriaTO> listarDiretoria(){
		ArrayList<DiretoriaTO> lista;
		DiretoriaDAO dao = new DiretoriaDAO();
		lista = dao.listarDiretoria();
		return lista;
	}
	
	public ArrayList<DiretoriaTO> listarDiretoria(String chave){
		ArrayList<DiretoriaTO> lista;
		DiretoriaDAO dao = new DiretoriaDAO();
		lista = dao.listarDiretoriaRG(chave);
		return lista;
}
	public ArrayList<ProfessorTO> listarProfessor(){
		ArrayList<ProfessorTO> lista;
		ProfessorDAO dao = new ProfessorDAO();
		lista = dao.listarProfessor();
		return lista;
	}
	
	public ArrayList<ProfessorTO> listarProfessor(String chave){
		ArrayList<ProfessorTO> lista;
		ProfessorDAO dao = new ProfessorDAO();
		lista = dao.listarProfessorRG(chave);
		return lista;
}

}



