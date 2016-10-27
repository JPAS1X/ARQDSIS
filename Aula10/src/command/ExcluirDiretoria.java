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

public class ExcluirDiretoria implements Command {

	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String pId = request.getParameter("id");
		String pNome = request.getParameter("nome");
		String pFone = request.getParameter("fone");
		String pRg = request.getParameter("rg");
		String pFoneF = request.getParameter("foneF");
		String pEndereco = request.getParameter("endereco");
		String pEmail = request.getParameter("email");
		String pUsuario = request.getParameter("usuario");
		String pSenha = request.getParameter("senha");
		String pPermissao = request.getParameter("permissao");
		int id = -1;
		try {
			id = Integer.parseInt(pId);
		} catch (Exception e) {

		}

		Diretoria diretoria = new Diretoria(id, pNome, pFone, pRg, pFoneF, pEndereco, pEmail, pUsuario, pSenha, pPermissao);
		RequestDispatcher view = null;
		HttpSession session = request.getSession();

		diretoria.excluir();
		@SuppressWarnings("unchecked")
		ArrayList<DiretoriaTO> lista = (ArrayList<DiretoriaTO>) session
				.getAttribute("lista");
		lista.remove(busca(diretoria, lista));
		session.setAttribute("lista", lista);
		view = request.getRequestDispatcher("ListarDiretoria.jsp");
		view.forward(request, response);
	}

	public int busca(Diretoria diretoria, ArrayList<DiretoriaTO> lista) {
		DiretoriaTO to;
		for (int i = 0; i < lista.size(); i++) {
			to = lista.get(i);
			if (to.getId() == diretoria.getId()) {
				return i;
			}
		}
		return -1;
	}

}
