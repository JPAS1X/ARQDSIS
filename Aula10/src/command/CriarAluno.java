package command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Aluno;
import to.AlunoTO;

public class CriarAluno implements Command {

	@Override
	public void executa (HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String pId = request.getParameter("id");
		String pNome = request.getParameter("nome");
		String pNomeM = request.getParameter("nomeM");
		String pRg = request.getParameter("rg");
		String pEndereco = request.getParameter("endereco");
		String pFoneF = request.getParameter("foneF");
		String pFone = request.getParameter("fone");
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
		
		Aluno aluno = new Aluno( id, pNome, pNomeM, pRg , pEndereco, pFoneF, pFone, pEmail, pCodProfessor, pUsuario, pSenha, pPermissao);
		
		HttpSession session = request.getSession();
		
		aluno.criar();
		ArrayList<AlunoTO> lista = new ArrayList<>();
		lista.add(aluno.getTO());
		session.setAttribute("lista", lista);
		RequestDispatcher view =  request.getRequestDispatcher("ListarAlunos.jsp");
		view.forward(request, response);
	}
}
