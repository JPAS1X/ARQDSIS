package command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Matricula;

public class ConsultarMatricula implements Command {


	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String pCodigo = request.getParameter("codigo");
		String pValor = request.getParameter("valor");
		String pData = request.getParameter("data ");
		String pStatusPagamento = request.getParameter("statusPagamento");
		String pStatusMatricula = request.getParameter("statusMatricula");
		String pCodProfessor = request.getParameter("codProfessor");
		String pCurso = request.getParameter("curso");
		String pAluno = request.getParameter("aluno");
		
		int codigo = -1;
		try {
			codigo = Integer.parseInt(pCodigo);
		} catch (Exception e) {

		}

		Matricula matricula = new Matricula (codigo, pValor, pData, pStatusPagamento, pStatusMatricula, pCodProfessor, pCurso, pAluno);
		RequestDispatcher view = null;

		matricula.carregar();
		request.setAttribute("matriculaTO", matricula.getTO());
		view = request.getRequestDispatcher("VisualizarMatricula.jsp");		


		view.forward(request, response);

	}
}
