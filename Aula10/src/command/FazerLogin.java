package command;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Usuario;


	public class FazerLogin implements Command {

		@Override
		public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String nome = request.getParameter("usuario");
			String senha = request.getParameter("senha");
			String permissao = request.getParameter("permissao");
			

			Usuario usuario = new Usuario(nome, senha, permissao);
			HttpSession session = request.getSession();
			if (usuario.validar()) {
				session.setAttribute("logado", usuario.getTO());
				System.out.println("Logou " + usuario.getTO());

			} else {
				System.out.println("Não Logou " + usuario.getTO());
				throw new ServletException("Usuario/Senha invalidos");
			}
		
		Object Adm = "Adm";
		Object Prof = "Prof";
		Object Alu = "Alu";
		
		
		if(permissao.equals(Adm)){
			response.sendRedirect("index.jsp");
		}else if(permissao.equals(Prof)){
			response.sendRedirect("MenuProfessor.jsp");
		}else if(permissao.equals(Alu)){
			response.sendRedirect("MenuAluno.jsp");
		}else{
			response.sendRedirect("MenuDiretoria.jsp");
		}
	}

}

