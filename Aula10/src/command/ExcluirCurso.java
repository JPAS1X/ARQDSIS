package command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.ManterCurso;
import to.CursoTO;

public class ExcluirCurso implements Command {
	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		CursoTO infoTO = new CursoTO();
		
 		String pCodigo = request.getParameter("codigo");
		infoTO.setNome(request.getParameter("nome"));
		infoTO.setTipo(request.getParameter("tipo"));
		infoTO.setDataInicio(request.getParameter("dataIni")); // nome do parametro do formulário 
		infoTO.setDataTermino(request.getParameter("dataTerm"));
		infoTO.setHorario(request.getParameter("horario")); // nome do parametro do formulário 
		infoTO.setNumeroVagas(request.getParameter("numVagas"));
		infoTO.setValor(request.getParameter("valor")); // nome do parametro do formulário 
		infoTO.setDisponibilidade(request.getParameter("disp"));
		int codigo = -1;
		try {
			codigo = Integer.parseInt(pCodigo);
			infoTO.setCodigo(codigo);
		} catch (NumberFormatException e) {

		}

		ManterCurso manterCurso = new ManterCurso(infoTO);
		RequestDispatcher view = null;
		HttpSession session = request.getSession(); // aqui estamos inicializando uma seção, com nome de session
		
		manterCurso.deletar();
		@SuppressWarnings("unchecked")
		ArrayList<CursoTO> lista = (ArrayList<CursoTO>)session.getAttribute("lista");
		lista.remove(busca(manterCurso, lista));
		session.setAttribute("lista", lista);
		view = request.getRequestDispatcher("ListarCurso.jsp");
		view.forward(request, response);
	}
	
	public int busca(ManterCurso manterInfo, ArrayList<CursoTO> lista) {
		CursoTO to;
		for(int i = 0; i < lista.size(); i++){
			to = lista.get(i);
			if(to.getCodigo() == manterInfo.getCodigo()){
				return i;
			}
		}
		return -1;
	}
}
		
		
		