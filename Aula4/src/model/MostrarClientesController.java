package model;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MostrarClientesController
 */
@WebServlet("/manter_clientes.do")
public class MostrarClientesController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MostrarClientesController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pId = request.getParameter("id");
		String pNome = request.getParameter("nome");
		String pFone = request.getParameter("fone");
		int id;
		try{
		id = Integer.parseInt(pId);
		} catch(NumberFormatException e){
			id = 0;
			e.printStackTrace();
		}
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>Cliente Cadastrado</title></head><body>");
		out.println("id "+pId+"<br>");
		out.println("nome "+pNome+"<br>");
		out.println("fone "+pFone+"<br>");
		out.println("</body></html>");
	}

}
