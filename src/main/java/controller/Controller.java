package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

import model.DAO;
import model.Cliente;

@WebServlet(urlPatterns = {"/main","/inserir","/select","/update","/delete"})
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	DAO dao = new DAO();
	Cliente cliente = new Cliente();
       
    public Controller() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	    String action = request.getServletPath();
	    System.out.println(action);
	    
	    if (action.equals("/main")) {
	    	clientes(request,response);
	    } else if (action.equals("/inserir")) {
	    	novoCliente(request,response);
	    } else if (action.equals("/select")) {
	    	listarCliente(request,response);
	    } else if (action.equals("/update")) {
	    	editarCliente(request,response);
	    } else if (action.equals("/delete")) {
	    	removerCliente(request,response);	
	    } else {
	    	response.sendRedirect("clientes.jsp");
	    }
	}
	
	protected void clientes(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ArrayList<Cliente> lista = dao.listarClientes();
		
		request.setAttribute("clientes", lista);
		RequestDispatcher rd = request.getRequestDispatcher("clientes.jsp");
		rd.forward(request,response);		
	}

	protected void novoCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		cliente.setNome(request.getParameter("nome"));
		cliente.setCpf(request.getParameter("cpf"));
		cliente.setLogin(request.getParameter("login"));
		cliente.setSenha(request.getParameter("senha"));
		
		dao.inserirCliente(cliente);

		response.sendRedirect("main");
	}
	
	
	protected void listarCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String id = request.getParameter("id");
		cliente.setId(id);

		dao.selecionarCliente(cliente);

		request.setAttribute("id", cliente.getId());	
		request.setAttribute("nome", cliente.getNome());
		request.setAttribute("cpf",cliente.getCpf());
		request.setAttribute("login",cliente.getLogin());
		request.setAttribute("senha",cliente.getSenha());

		RequestDispatcher rd = request.getRequestDispatcher("editar.jsp");
		rd.forward(request, response);	}

	protected void editarCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		cliente.setId(request.getParameter("id"));
		cliente.setNome(request.getParameter("nome"));
		cliente.setCpf(request.getParameter("cpf"));
		cliente.setLogin(request.getParameter("login"));
		cliente.setSenha(request.getParameter("senha"));

		dao.alterarCliente(cliente);

		response.sendRedirect("main");		
	}

	protected void removerCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String id = request.getParameter("id");

		cliente.setId(id);

		dao.deletarCliente(cliente);

		response.sendRedirect("main");
	}

}
