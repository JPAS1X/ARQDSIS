package command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Diretoria;
import to.DiretoriaTO;

public class CadastrarDiretoria implements Command {

	@Override
	public void executa (HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String pId = request.getParameter("id");
		String pNome = request.getParameter("nome");
		String pRg = request.getParameter("rg");
		String pUnidade = request.getParameter("unidade");
		String pFone = request.getParameter("fone");
		String pFoneF = request.getParameter("foneF");
		String pEmail = request.getParameter("email");
		String pUsuario = request.getParameter("usuario");
		String pSenha = request.getParameter("senha");
		String pPermissao = request.getParameter("permissao");
		
		int id = -1;
		try {
			id = Integer.parseInt(pId);
		} catch (Exception e) {

		}
		
		Diretoria diretoria = new Diretoria( id, pNome, pRg , pUnidade, pFone, pFoneF, pEmail, pUsuario, pSenha, pPermissao);
		
		HttpSession session = request.getSession();
		
		diretoria.criar();
		ArrayList<DiretoriaTO> lista = new ArrayList<>();
		lista.add(diretoria.getTO());
		session.setAttribute("lista", lista);
		RequestDispatcher view =  request.getRequestDispatcher("ListarDiretoria.jsp");
		view.forward(request, response);
	}
}
