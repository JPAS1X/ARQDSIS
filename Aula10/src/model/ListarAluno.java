package model;

import java.util.ArrayList;
import dao.*;
import to.AlunoTO;

public class ListarAluno {
	
	public ArrayList<AlunoTO> listarAluno(){
		ArrayList<AlunoTO> lista;
		AlunoDAO dao = new AlunoDAO();
		lista = ((AlunoDAO) dao).listarAlunos();
		return lista;
	}

	public ArrayList<AlunoTO> listarAluno(String chave){
		ArrayList<AlunoTO> lista;
		AlunoDAO dao = new AlunoDAO();
		if (Character.isDigit(chave.charAt(0))==true){
			lista = dao.listarAlunosRG(chave);
		}
		else {
			lista = dao.listarAlunosRG(chave);
		}

		return lista;
		
		
		
	}
			
	
		
		
	}
	
	
