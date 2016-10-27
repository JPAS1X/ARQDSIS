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

public class CadastrarProfessor implements Command {
	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
				
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
		} catch (Exception e) {

		}
		
		Professor professor = new Professor(codigo, pNome, pRg, pDataAdm, pTelefone, pCelular, pEmail, pCurso, pUsuario, pSenha, pPermissao);
		
		HttpSession session = request.getSession();
		
		professor.criar();
		ArrayList<ProfessorTO> lista = new ArrayList<>();
		lista.add(professor.getTO());
		session.setAttribute("lista", lista);
		RequestDispatcher view =  request.getRequestDispatcher("ListarProfessor.jsp");
		view.forward(request, response);
	}
}
