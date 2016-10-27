package model;

import java.util.ArrayList;

import dao.InformativoAulaDAO;
import to.InformativoAulaTO;

public class ListarInformativoAula {


	public ArrayList<InformativoAulaTO> listarInformativoAula(){
		ArrayList<InformativoAulaTO> lista;
		InformativoAulaDAO dao = new InformativoAulaDAO();
		lista = dao.listarInformativoAula();
		return lista;
	}

	public ArrayList<InformativoAulaTO> listarInformativoAulaCodigo(String chave){
		ArrayList<InformativoAulaTO> lista;
		InformativoAulaDAO dao = new InformativoAulaDAO();
		lista = dao.listarInformativoAulaCodigo(chave);
		return lista;
	}
}
