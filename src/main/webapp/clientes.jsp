<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="model.Cliente" %>
<%@ page import="java.util.ArrayList"  %>
<%
	ArrayList<Cliente> lista = (ArrayList<Cliente>) request.getAttribute("clientes");
%>
<!DOCTYPE html>
<html lang="pt-br">

<head>
<meta charset="utf-8">
<title>Lista de Clientes</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
</head>

<body class="text-center">

 <header>
    <br> <br>
	<h1 class="h3 mb-3 fw-normal">Lista de Clientes</h1>
	 <br>
	<a href="novo.html" class="btn btn-sm btn-outline-secondary">Novo Cliente</a>
    <a href="Cadastro.html" class="btn btn-sm btn-outline-secondary">Voltar para a tela de Cadastro</a>
</header>
    
    <br>
    <br>
   
    <main>
	
	<table class="table table-bordered">
		<thead>
			<tr>
				<th scope="col">Id</th>
				<th scope="col">Nome</th>
				<th scope="col">CPF</th>
				<th scope="col">Login</th>
				<th scope="col">Senha</th>
				<th scope="col">Opções</th>
			</tr>
		</thead>
		
		<tbody>
			<%for (int i=0 ; i < lista.size() ; i++) { %>
				<tr>
				    <td><%=lista.get(i).getId() %></td>
					<td><%=lista.get(i).getNome() %></td>
					<td><%=lista.get(i).getCpf() %></td>
					<td><%=lista.get(i).getLogin() %></td>
					<td><%=lista.get(i).getSenha() %></td>
					<td><a class="btn btn-secondary" href="select?id=<%=lista.get(i).getId()%>">Editar</a>  
					<a class="btn btn-danger" href="delete?id=<%=lista.get(i).getId()%>">Excluir</a></td>
				</tr>
			<%} %>
		</tbody>
	</table>
	
	</main>
	
</body>
</html>