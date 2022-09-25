package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

import model.DestinoDAO;
import model.Destino;

@WebServlet(urlPatterns = {"/mainD","/inserirD","/selectD","/updateD","/deleteD"})
public class ContrDestino extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	DestinoDAO dao = new DestinoDAO();
	Destino destino = new Destino();
       
    public ContrDestino() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	    String action = request.getServletPath();
	    System.out.println(action);
	    
	    if (action.equals("/mainD")) {
	    	destinos(request,response);
	    } else if (action.equals("/inserirD")) {
	    	novoDestino(request,response);
	    } else if (action.equals("/selectD")) {
	    	listarDestino(request,response);
	    } else if (action.equals("/updateD")) {
	    	editarDestino(request,response);
	    } else if (action.equals("/deleteD")) {
	    	removerDestino(request,response);	
	    } else {
	    	response.sendRedirect("destinos.jsp");
	    }
	}
	
	protected void destinos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Destino> lista = dao.listarDestinos();
		
		request.setAttribute("destinos", lista);
		RequestDispatcher rd = request.getRequestDispatcher("destinos.jsp");
		rd.forward(request,response);
		
	}

	protected void novoDestino(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		destino.setNome(request.getParameter("nome"));
		destino.setValor(request.getParameter("valor"));
		destino.setLocalidade(request.getParameter("localidade"));
		destino.setProprietario(request.getParameter("proprietario"));
		
		dao.inserirDestino(destino);
		
		response.sendRedirect("mainD");
	}
	
	
	protected void listarDestino(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		destino.setId(id);
		
		dao.selecionarDestino(destino);
		
		request.setAttribute("id", destino.getId());	
		request.setAttribute("nome", destino.getNome());
		request.setAttribute("valor",destino.getValor());
		request.setAttribute("localidade",destino.getLocalidade());
		request.setAttribute("proprietario",destino.getProprietario());

		RequestDispatcher rd = request.getRequestDispatcher("editarD.jsp");
		rd.forward(request, response);	}

	protected void editarDestino(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		destino.setId(request.getParameter("id"));
		destino.setNome(request.getParameter("nome"));
		destino.setValor(request.getParameter("valor"));
		destino.setLocalidade(request.getParameter("localidade"));
		destino.setProprietario(request.getParameter("proprietario"));
		
		dao.alterarDestino(destino);
		
		response.sendRedirect("mainD");		
	}

	protected void removerDestino(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String id = request.getParameter("id");

		destino.setId(id);

		dao.deletarDestino(destino);

		response.sendRedirect("mainD");
	}

}
