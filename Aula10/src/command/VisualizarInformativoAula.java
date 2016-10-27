package command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.InformativoAula;
import to.InformativoAulaTO;

public class VisualizarInformativoAula implements Command {

	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String pCodigo = request.getParameter("codigo");
		String pData = request.getParameter("data");
		String pNomeProfessor = request.getParameter("nomeProfessor");	
		String pConteudo = request.getParameter("conteudo");
		
		int codigo = -1;
		try {
			codigo = Integer.parseInt(pCodigo);
		} catch (Exception e) {

		}

		InformativoAula informativoAula = new InformativoAula(codigo, pData, pNomeProfessor, pConteudo);
		RequestDispatcher view = null;

		informativoAula.carregar();
		request.setAttribute("informativoAula", informativoAula.getTO());
		view = request.getRequestDispatcher("VisualizarInformativoAula.jsp");
		view.forward(request, response);
	}

	public int busca(InformativoAula informativoAula, ArrayList<InformativoAulaTO> lista) {
		InformativoAulaTO to;
		for (int i = 0; i < lista.size(); i++) {
			to = lista.get(i);
			if (to.getCodigo() == informativoAula.getCodigo()) {
				return i;
			}
		}
		return -1;
	}

}
