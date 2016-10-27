package command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Vendedor;
import to.DiretoriaTO;

public class ListarDiretoriaBuscar implements Command {

	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String chave = request.getParameter("data[search]");
		
		Vendedor vendedor = new Vendedor();
		ArrayList<DiretoriaTO> lista = null;
		HttpSession session = request.getSession();

		if (chave != null && chave.length() > 0) {
			lista = vendedor.listarDiretoria(chave);
		} else {
			lista = vendedor.listarDiretoria(); 
		}
		session.setAttribute("lista", lista);

		RequestDispatcher dispatcher = request.getRequestDispatcher("ListarDiretoria.jsp");
		dispatcher.forward(request, response);
	}
}
