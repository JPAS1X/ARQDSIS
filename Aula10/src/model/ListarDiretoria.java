package model;

import java.util.ArrayList;

import dao.DiretoriaDAO;
import to.DiretoriaTO;

public class ListarDiretoria {
	
	public ArrayList<DiretoriaTO> listarDiretoria(){
		ArrayList<DiretoriaTO> lista;
		DiretoriaDAO dao = new DiretoriaDAO();
		lista = ((DiretoriaDAO) dao).listarDiretoria();
		return lista;
	}

	public ArrayList<DiretoriaTO> listarDiretoria(String chave){
		ArrayList<DiretoriaTO> lista;
		DiretoriaDAO dao = new DiretoriaDAO();
		if (Character.isDigit(chave.charAt(0))==true){
			lista = dao.listarDiretoriaRG(chave);
		}
		else {
			lista = dao.listarDiretoriaRG(chave);
		}

		return lista;
		
		
		
	}
			
	
		
		
	}
	
	
