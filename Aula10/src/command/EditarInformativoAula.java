package command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.InformativoAula;

public class EditarInformativoAula implements Command{
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

		informativoAula.carregar();
		request.setAttribute("informativoAula", informativoAula.getTO());
		view = request.getRequestDispatcher("AlterarInformativoAula.jsp");

		view.forward(request, response);

	}
}
