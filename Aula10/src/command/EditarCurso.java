package command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Curso;


public class EditarCurso implements Command{
	
	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String pCodigo = request.getParameter("codigo");
 		String tipo = request.getParameter("tipo");
 		String nome = request.getParameter("nome");
		String dataIni = request.getParameter("dataIni"); // nome do parametro do formulário 
		String dataTerm = request.getParameter("dataTerm");
		String horario = request.getParameter("horario"); // nome do parametro do formulário 
		String numVagas = request.getParameter("numVagas");
		String valor = request.getParameter("valor"); // nome do parametro do formulário 
		String disp = request.getParameter("disp");
		int codigo = -1;
		try {
			codigo = Integer.parseInt(pCodigo);
		} catch (NumberFormatException e) {
		}

		Curso curso = new Curso(codigo,tipo, nome,dataIni,dataTerm,horario,numVagas,valor,disp);
		RequestDispatcher view = null;
		
		curso.carregar();
		request.setAttribute("curso", curso.getTO());
		view = request.getRequestDispatcher("AlterarCurso.jsp");
		
		view.forward(request, response);
	}

}
