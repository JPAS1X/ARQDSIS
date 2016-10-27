package command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.ListarCurso;
import to.CursoTO;

public class ListarCursoBuscar implements Command  {
	
	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String chave = request.getParameter("data[search]");

		ListarCurso lI = new ListarCurso();
		ArrayList<CursoTO> lista =null;
		HttpSession session = request.getSession();  // temos que iniciar a seção

		if(chave != null && chave.length() > 0){
			lista = lI.listarCurso(chave);
		} else {				
			lista = lI.listarCurso();
		}
		session.setAttribute("lista", lista);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("ListarCurso.jsp");
		dispatcher.forward(request, response);
	}
}


