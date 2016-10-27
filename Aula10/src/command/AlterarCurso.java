package command;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Curso;
import to.CursoTO;

public class AlterarCurso implements Command {
	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String pCodigo = request.getParameter("codigo");
 		String tipo = request.getParameter("tipo");
 		String nome = request.getParameter("nome");
		String dataIni = request.getParameter("dataIni"); // nome do parametro do formulário 
		String dataTerm = request.getParameter("dataTerm");
		String horario = request.getParameter("horario"); // nome do parametro do formulário 
		String numVagas = request.getParameter("numVagas");
		String valor = request.getParameter("valor"); // nome do parametro do formulário 
		String disp = request.getParameter("disp");
		
		int codigo = -1;
		try {
			codigo = Integer.parseInt(pCodigo);
		} catch (Exception e) {

		}

		Curso curso = new Curso(codigo,tipo, nome,dataIni,dataTerm,horario,numVagas,valor,disp);
		RequestDispatcher view = null;
		HttpSession session = request.getSession(); // aqui estamos inicializando uma seção, com nome de session

		curso.atualizar();
		@SuppressWarnings("unchecked")
		ArrayList<CursoTO> lista = (ArrayList<CursoTO>)session.getAttribute("lista");
		int pos = busca(curso, lista);
		lista.remove(pos);
		lista.add(pos, curso.getTO());
		session.setAttribute("lista", lista);
		request.setAttribute("curso", curso.getTO());		
		view = request.getRequestDispatcher("ListarCurso.jsp");
		view.forward(request, response);
	}
	public int busca(Curso curso, ArrayList<CursoTO> lista) {
		CursoTO to;
		for(int i = 0; i < lista.size(); i++){
			to = lista.get(i);
			if(to.getCodigo() == curso.getCodigo()){
				return i;
			}
		}
		return -1;
	}
}
		
		
		
		
		