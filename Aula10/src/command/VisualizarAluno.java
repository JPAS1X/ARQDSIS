package command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Aluno;
import to.AlunoTO;

public class VisualizarAluno implements Command {

	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String pId = request.getParameter("id");
		String pNome = request.getParameter("nome");
		String pFone = request.getParameter("fone");
		String pRg = request.getParameter("rg");
		String pNomeM = request.getParameter("nomeM");
		String pFoneF = request.getParameter("foneF");
		String pEndereco = request.getParameter("endereco");
		String pEmail = request.getParameter("email");
		String pCodProfessor = request.getParameter("codProfessor");
		String pUsuario = request.getParameter("usuario");
		String pSenha = request.getParameter("senha");
		String pPermissao = request.getParameter("permissao");
		int id = -1;
		try {
			id = Integer.parseInt(pId);
		} catch (Exception e) {

		}

		Aluno aluno = new Aluno(id, pNome, pFone, pRg, pNomeM, pFoneF, pEndereco, pEmail, pCodProfessor,pUsuario, pSenha, pPermissao);
		RequestDispatcher view = null;

		aluno.carregar();
		request.setAttribute("aluno", aluno.getTO());
		view = request.getRequestDispatcher("VisualizarAluno.jsp");
		view.forward(request, response);
	}

	public int busca(Aluno aluno, ArrayList<AlunoTO> lista) {
		AlunoTO to;
		for (int i = 0; i < lista.size(); i++) {
			to = lista.get(i);
			if (to.getId() == aluno.getId()) {
				return i;
			}
		}
		return -1;
	}

}
