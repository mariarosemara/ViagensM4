<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<title>Editar Empresa</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
</head>

<body class="text-center">
<script src="scripts/validadorE.js"></script>

	<header>
       <br> <br>
	   <h1 class="h3 mb-3 fw-normal">Editar Empresa</h1>
	</header>
	
    <br>
    
    <main>
	   <form name="frmEmpresa" action="updateE">
	   

         <div class="form-floating">
        	<input type="text" name="id" readonly value="<%out.print(request.getAttribute("id"));%>"><br>
            <label for="floatingInput">ID</label>
         </div>
        
         
         <div class="form-floating">
        	<input type="text" name="cnpj" value="<%out.print(request.getAttribute("cnpj"));%>"><br>
            <label for="floatingInput">CNPJ</label>
         </div>
        
         
         <div class="form-floating">
        	<input type="text" name="localidade" value="<%out.print(request.getAttribute("localidade"));%>"><br>
            <label for="floatingInput">LOCALIDADE</label>
         </div>
        
         
         <div class="form-floating">
        	<input type="text" name="proprietario" value="<%out.print(request.getAttribute("proprietario"));%>"><br>
            <label for="floatingInput">PROPRIETÁRIO</label>
         </div>
        
         
         <div class="form-floating">
        	<input type="text" name="login" value="<%out.print(request.getAttribute("login"));%>"><br>
            <label for="floatingInput">LOGIN</label>
         </div>
        
         
         <div class="form-floating">
        	<input type="text" name="senha" value="<%out.print(request.getAttribute("senha"));%>"><br>
            <label for="floatingInput">SENHA</label>
         </div>
         <br>
        
		   <input type="button" class="btn btn-primary" value="Salvar" onclick="validarE()">
		 </form>

        <br> 
   </main>

   <a href="/ViagensM4/mainE">Voltar para a lista de Empresas</a>
     <br>
   <p class="mt-5 mb-3 text-muted">&copy; 2022 - Viagens</p>
   
   </body>
</html>