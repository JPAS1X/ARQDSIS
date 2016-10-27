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

public class CadastrarInformativoAula implements Command {
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
		
		HttpSession session = request.getSession();
		
		informativoAula.criar();
		ArrayList<InformativoAulaTO> lista = new ArrayList<>();
		lista.add(informativoAula.getTO());
		session.setAttribute("lista", lista);
		RequestDispatcher view =  request.getRequestDispatcher("ListarInformativoAula.jsp");
		view.forward(request, response);
	}
}
