package command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Matricula;
import to.MatriculaTO;

public class VisualizarMatricula implements Command {

	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String pCodigo = request.getParameter("codigo");
		String pValor = request.getParameter("valor");
		String pData = request.getParameter("data");
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

		Matricula matricula = new Matricula(codigo, pValor, pData, pStatusPagamento, pStatusMatricula, pCodProfessor, pCurso, pAluno);
		RequestDispatcher view = null;

		matricula.carregar();
		request.setAttribute("matricula", matricula.getTO());
		view = request.getRequestDispatcher("VisualizarMatricula.jsp");
		view.forward(request, response);
	}

	public int busca(Matricula matricula, ArrayList<MatriculaTO> lista) {
		MatriculaTO to;
		for (int i = 0; i < lista.size(); i++) {
			to = lista.get(i);
			if (to.getCodigo() == matricula.getCodigo()) {
				return i;
			}
		}
		return -1;
	}

}
