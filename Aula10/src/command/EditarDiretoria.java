package command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Diretoria;

public class EditarDiretoria implements Command {

	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String pId = request.getParameter("id");
		String pNome = request.getParameter("nome");
		String pFone = request.getParameter("fone");
		String pRg = request.getParameter("rg");
		String pFoneF = request.getParameter("foneF");
		String pUnidade = request.getParameter("unidade");
		String pEmail = request.getParameter("email");
		String pUsuario = request.getParameter("usuario");
		String pSenha = request.getParameter("senha");
		String pPermissao = request.getParameter("permissao");
		int id = -1;
		try {
			id = Integer.parseInt(pId);
		} catch (Exception e) {

		}

		Diretoria diretoria = new Diretoria (id, pNome, pFone, pRg, pFoneF, pUnidade, pEmail, pUsuario, pSenha, pPermissao);
		RequestDispatcher view = null;

		diretoria.carregar();
		request.setAttribute("diretoria", diretoria.getTO());
		view = request.getRequestDispatcher("AlterarDiretoria.jsp");

		view.forward(request, response);

	}
}
