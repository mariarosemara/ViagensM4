package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

import model.EmpreDAO;
import model.Empresa;

@WebServlet(urlPatterns = {"/mainE","/inserirE","/selectE","/updateE","/deleteE"})
public class ContrEmpre extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	EmpreDAO dao = new EmpreDAO();
	Empresa empresa = new Empresa();
       
    public ContrEmpre() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	    String action = request.getServletPath();
	    System.out.println(action);
	    
	    if (action.equals("/mainE")) {
	    	empresas(request,response);
	    } else if (action.equals("/inserirE")) {
	    	novaEmpresa(request,response);
	    } else if (action.equals("/selectE")) {
	    	listarEmpresa(request,response);
	    } else if (action.equals("/updateE")) {
	    	editarEmpresa(request,response);
	    } else if (action.equals("/deleteE")) {
	    	removerEmpresa(request,response);	
	    } else {
	    	response.sendRedirect("empresas.jsp");
	    }
	}
	
	protected void empresas(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ArrayList<Empresa> lista = dao.listarEmpresas();
		
		request.setAttribute("empresas", lista);
		RequestDispatcher rd = request.getRequestDispatcher("empresas.jsp");
		rd.forward(request,response);
		
	}

	protected void novaEmpresa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		empresa.setCnpj(request.getParameter("cnpj"));
		empresa.setLocalidade(request.getParameter("localidade"));
		empresa.setProprietario(request.getParameter("proprietario"));
		empresa.setLogin(request.getParameter("login"));
		empresa.setSenha(request.getParameter("senha"));
		
		
		dao.inserirEmpresa(empresa);
		
		response.sendRedirect("mainE");
	}
	
	protected void listarEmpresa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		empresa.setId(id);

		dao.selecionarEmpresa(empresa);

		request.setAttribute("id", empresa.getId());
		request.setAttribute("cnpj", empresa.getCnpj());
		request.setAttribute("localidade", empresa.getLocalidade());
		request.setAttribute("proprietario", empresa.getProprietario());
		request.setAttribute("login", empresa.getLogin());
		request.setAttribute("senha", empresa.getSenha());

		RequestDispatcher rd = request.getRequestDispatcher("editarE.jsp");
		rd.forward(request, response);	}

	protected void editarEmpresa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		empresa.setId(request.getParameter("id"));
		empresa.setCnpj(request.getParameter("cnpj"));
		empresa.setLocalidade(request.getParameter("localidade"));
		empresa.setProprietario(request.getParameter("proprietario"));
		empresa.setLogin(request.getParameter("login"));
		empresa.setSenha(request.getParameter("senha"));

		dao.alterarEmpresa(empresa);

		response.sendRedirect("mainE");		
	}

	protected void removerEmpresa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String id = request.getParameter("id");

		empresa.setId(id);

		dao.deletarEmpresa(empresa);

		response.sendRedirect("mainE");
	}

}
