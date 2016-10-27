package command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.InformativoAula;
import to.InformativoAulaTO;

public class ExcluirInformativoAula implements Command {
	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
				
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
		HttpSession session = request.getSession();

		informativoAula.excluir();
		@SuppressWarnings("unchecked")
		ArrayList<InformativoAulaTO> lista = (ArrayList<InformativoAulaTO>) session
				.getAttribute("lista");
		lista.remove(busca(informativoAula, lista));
		session.setAttribute("lista", lista);
		view = request.getRequestDispatcher("ListarInformativoAula.jsp");
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
