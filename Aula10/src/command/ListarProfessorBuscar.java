package command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.ListarProfessor;
import to.ProfessorTO;

public class ListarProfessorBuscar implements Command  {
	
	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String chave = request.getParameter("data[search]");

		ListarProfessor lI = new ListarProfessor();
		ArrayList<ProfessorTO> lista =null;
		HttpSession session = request.getSession();  // temos que iniciar a se��o

		if(chave != null && chave.length() > 0){
			lista = lI.listarProfessorRG(chave);
		} else {				
			lista = lI.listarProfessor();
		}
		session.setAttribute("lista", lista);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("ListarProfessor.jsp");
		dispatcher.forward(request, response);
	}
}


