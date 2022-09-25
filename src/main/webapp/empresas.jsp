<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="model.Empresa" %>
<%@ page import="java.util.ArrayList"  %>
<%
	ArrayList<Empresa> lista = (ArrayList<Empresa>) request.getAttribute("empresas");
%>
<!DOCTYPE html>
<html lang="pt-br">

<head>
<meta charset="utf-8">
<title>Lista de Empresas</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
</head>

<body class="text-center">

 <header>
    <br> <br>
	<h1 class="h3 mb-3 fw-normal">Lista de Empresas</h1>
	 <br>
	<a href="NovaEmpr.html" class="btn btn-sm btn-outline-secondary">Nova Empresa</a>
    <a href="Cadastro.html" class="btn btn-sm btn-outline-secondary">Voltar para a tela de Cadastro</a>
</header>
    
    <br>
    <br>
   
    <main>
	
	<table class="table table-bordered">
		<thead>
			<tr>
				<th scope="col">Id</th>
				<th scope="col">CNPJ</th>
				<th scope="col">Localidade</th>
				<th scope="col">Proprietário</th>
				<th scope="col">Login</th>
				<th scope="col">Senha</th>
				<th scope="col">Opções</th>
			</tr>
		</thead>
		<tbody>
			<%for (int i=0 ; i < lista.size() ; i++) { %>
				<tr>
				    <td><%=lista.get(i).getId() %></td>
					<td><%=lista.get(i).getCnpj() %></td>
					<td><%=lista.get(i).getLocalidade() %></td>
					<td><%=lista.get(i).getProprietario() %></td>
					<td><%=lista.get(i).getLogin() %></td>
					<td><%=lista.get(i).getSenha() %></td>
					<td><a class="btn btn-secondary" href="selectE?id=<%=lista.get(i).getId()%>">Editar</a>
					<a class="btn btn-danger" href="deleteE?id=<%=lista.get(i).getId()%>">Excluir</a></td>
				</tr>
			<%} %>
		</tbody>
	</table>
	
		
	</main>
	
	
</body>
</html>