package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Curso;

@WebServlet("/Manter_Curso.do")

/**
 * Servlet implementation class ManterCursoController
 */

public class ManterCursoController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pAcao = request.getParameter("acao");
		String pNome = request.getParameter("nome");
		String pTipo = request.getParameter("tipo");
		String pDataInicio = request.getParameter("dataInicio");
		String pDataTermino = request.getParameter("dataTermino");
		String pHorario = request.getParameter("horario");
		double pValor = Double.parseDouble(request.getParameter("valor"));
		int pNumeroVagas = Integer.parseInt(request.getParameter("numeroVagas"));
		String pTipoLaboratorio = request.getParameter("tipoLaboratorio");
		String pSoftwares = request.getParameter("softwares");
		String pLivros = request.getParameter("livros");
		String pDescricao = request.getParameter("descricao");
	
		int pCodigo = Integer.parseInt(request.getParameter("codigo"));
		
		Curso curso = new Curso(pCodigo, pNome, pTipo, pDataInicio, pDataTermino, pHorario, pValor, pNumeroVagas, pTipoLaboratorio, pSoftwares, pLivros, pDescricao);
		if(pAcao.equals("Inserir")){
			curso.criar();
		} else if (pAcao.equals("Atualizar")){
			curso.atualizar();
		} else if (pAcao.equals("Excluir")){
			curso.excluir();
		}
		curso.carregar();
		
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>Cliente Cadastrado");
		out.println("</title>Curso</head><body>");
		out.println("Código: "+curso.getCodigo()+"<br>");
		out.println("Nome: "+curso.getNome()+"<br>");
		out.println("Tipo: "+curso.getTipo()+"<br>");
		out.println("Data de Inicio: "+curso.getDataDeInicio()+"<br>");
		out.println("Data de Termino: "+curso.getDataDeTermino()+"<br>");
		out.println("Horario: "+curso.getHorario()+"<br>");
		out.println("Numero de Vagas: "+curso.getNumeroDeVagas()+"<br>");
		out.println("Valor: "+curso.getValor()+"<br>");
		out.println("Tipo de Laboratorio: "+curso.getTipoLab()+"<br>");
		out.println("Softwares: "+curso.getSoftwares()+"<br>");
		out.println("Livros: "+curso.getLivros()+"<br>");
		out.println("Descrição: "+curso.getDescricao()+"<br>");
		out.println("</body></html>");
	}
	
}
