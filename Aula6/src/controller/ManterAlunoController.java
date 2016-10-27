package controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Aluno;
import to.AlunoTO;

@WebServlet("/Manter_Aluno.do")

public class ManterAlunoController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pAcao = request.getParameter("acao");
		String pNome = request.getParameter("nome");
		String pSexo = request.getParameter("sexo");
		String pDataNascimento = request.getParameter("dataNascimento");
		String pEndereco = request.getParameter("endereco");
		int pNumero = Integer.parseInt(request.getParameter("numero"));
		String pComplemento = request.getParameter("complemento");
		String pRg = request.getParameter("rg");
		String pCpf = request.getParameter("cpf");
		String pTelefone = request.getParameter("telefone");
		String pEmail = request.getParameter("email");
		
		int pCodigo = Integer.parseInt(request.getParameter("codigo"));
		
		Aluno aluno = new Aluno(pCodigo, pNome, pSexo, pDataNascimento, pEndereco, pNumero, pComplemento, pRg, pCpf, pTelefone, pEmail);
		if(pAcao.equals("Inserir")){
			aluno.criar();
		} else if (pAcao.equals("Atualizar")){
			aluno.atualizar();
		} else if (pAcao.equals("Excluir")){
			aluno.excluir();
		}
		aluno.carregar();
		
		AlunoTO to = new AlunoTO();
		to.setCodigo(aluno.getCodigo());
		to.setNome(aluno.getNome());
		to.setSexo(aluno.getSexo());
		to.setDataNascimento(aluno.getDataNascimento());
		to.setEndereco(aluno.getEndereco());
		to.setNumero(aluno.getNumero());;
		to.setComplemento(aluno.getComplemento());
		to.setRG(aluno.getRG());
		to.setCPF(aluno.getCPF());
		to.setTelefone(aluno.getTelefone());
		to.setEmail(aluno.getEmail());
		
		request.setAttribute("aluno", to);
		
		RequestDispatcher view = request.getRequestDispatcher("Aluno.jsp");
		view.forward(request, response);
	}

}	

