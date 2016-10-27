package command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Professor;
import to.ProfessorTO;

public class AlterarProfessor implements Command {
	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		ProfessorTO infoTO = new ProfessorTO();

		String pCodigo = request.getParameter("codigo");
		String pNome = request.getParameter("nome");
		String pRg = request.getParameter("rg");
		String pDataAdm = request.getParameter("dataAdm"); // nome do parametro do formulário 
		String pTelefone = request.getParameter("telefone");
		String pCelular = request.getParameter("celular"); // nome do parametro do formulário 
		String pEmail = request.getParameter("email");
		String pCurso = request.getParameter("curso"); // nome do parametro do formulário 
		String pUsuario = request.getParameter("usuario"); // nome do parametro do formulário 
		String pSenha = request.getParameter("senha");
		String pPermissao = request.getParameter("permissao");
		int codigo = -1;
		try {
			codigo = Integer.parseInt(pCodigo);
			infoTO.setCodigo(codigo);
		} catch (NumberFormatException e) {

		}
		Professor professor = new Professor(codigo, pNome, pRg, pDataAdm, pTelefone, pCelular, pEmail, pCurso, pUsuario, pSenha, pPermissao);
		RequestDispatcher view = null;
		HttpSession session = request.getSession();

		professor.atualizar();
		@SuppressWarnings("unchecked")
		ArrayList<ProfessorTO> lista = (ArrayList<ProfessorTO>) session
				.getAttribute("lista");
		int pos = busca(professor, lista);
		lista.remove(pos);
		lista.add(pos, professor.getTO());
		session.setAttribute("lista", lista);
		request.setAttribute("professor", professor.getTO());
		view = request.getRequestDispatcher("VisualizarProfessor.jsp");
		view.forward(request, response);
	}

	public int busca(Professor professor, ArrayList<ProfessorTO> lista) {
		ProfessorTO to;
		for (int i = 0; i < lista.size(); i++) {
			to = lista.get(i);
			if (to.getCodigo() == professor.getCodigo()) {
				return i;
			}
		}
		return -1;
	}

}
