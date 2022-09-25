<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<title>Editar Destino</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
</head>

<body class="text-center">
<script src="scripts/validadorD.js"></script>

	<header>
       <br> <br>
	   <h1 class="h3 mb-3 fw-normal">Editar Destino</h1>
	</header>
	
    <br>
    
    <main>
	   <form name="frmDestino" action="updateD">
	   
        	<div class="form-floating">
        	  <input type="text" name="id" readonly value="<%out.print(request.getAttribute("id"));%>"><br>
              <label for="floatingInput">ID</label>
            </div>

        	<div class="form-floating">
        	  <input type="text" name="nome" value="<%out.print(request.getAttribute("nome"));%>"><br>
              <label for="floatingInput">NOME</label>
             </div>
     
        	<div class="form-floating">
        	   <input type="text" name="valor" value="<%out.print(request.getAttribute("valor"));%>"><br>
               <label for="floatingInput">VALOR</label>
            </div>
         
        	<div class="form-floating">
        	   <input type="text" name="localidade" value="<%out.print(request.getAttribute("localidade"));%>"><br>
               <label for="floatingInput">LOCALIDADE</label>
            </div>
        
        	<div class="form-floating">
        	  <input type="text" name="proprietario" value="<%out.print(request.getAttribute("proprietario"));%>"><br>
              <label for="floatingInput">PROPRIETÁRIO</label>
            </div>
        
		  <input type="button" class="btn btn-primary" value="Salvar" onclick="validarD()">
	  </form>

          <br> 
   </main>

   <a href="/ViagensM4/mainD">Voltar para a lista de Destinos</a>
     <br>
   <p class="mt-5 mb-3 text-muted">&copy; 2022 - Viagens</p>
   
</body>
</html>