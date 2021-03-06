package command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.ListarInformativoAula;
import to.InformativoAulaTO;

public class ListarInformativoAulaBuscar implements Command  {
	
	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String chave = request.getParameter("data[search]");

		ListarInformativoAula lI = new ListarInformativoAula();
		ArrayList<InformativoAulaTO> lista =null;
		HttpSession session = request.getSession();  // temos que iniciar a se��o

		if(chave != null && chave.length() > 0){
			lista = lI.listarInformativoAulaCodigo(chave);
		} else {				
			lista = lI.listarInformativoAula();
		}
		session.setAttribute("lista", lista);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("ListarInformativoAula.jsp");
		dispatcher.forward(request, response);
	}
}




