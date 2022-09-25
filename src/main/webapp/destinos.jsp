<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="model.Destino" %>
<%@ page import="java.util.ArrayList"  %>
<%
	ArrayList<Destino> lista = (ArrayList<Destino>) request.getAttribute("destinos");
%>
<!DOCTYPE html>
<html lang="pt-br">

<head>
<meta charset="utf-8">
<title>Lista de Destinos</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
</head>

<body class="text-center">

 <header>
    <br> <br>
	<h1 class="h3 mb-3 fw-normal">Lista de Destinos</h1>
	<br>
	<a href="NovoDestino.html" class="btn btn-sm btn-outline-secondary">Novo Destino</a>
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
				<th scope="col">Valor</th>
				<th scope="col">Localidade</th>
				<th scope="col">Proprietario</th>
				<th scope="col">Opções</th>
			</tr>
		</thead>
		
		<tbody>
			<%for (int i=0 ; i < lista.size() ; i++) { %>
				<tr>
				    <td><%=lista.get(i).getId() %></td>
					<td><%=lista.get(i).getNome() %></td>
					<td><%=lista.get(i).getValor() %></td>
					<td><%=lista.get(i).getLocalidade() %></td>
					<td><%=lista.get(i).getProprietario() %></td>
					<td><a class="btn btn-secondary" href="selectD?id=<%=lista.get(i).getId()%>">Editar</a>
					<a class="btn btn-danger" href="deleteD?id=<%=lista.get(i).getId()%>">Excluir</a></td>
				</tr>
			<%} %>
		</tbody>
	</table>
	
		
	</main>
	
	
</body>
</html>