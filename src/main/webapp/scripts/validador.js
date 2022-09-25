function validar() {
	let nome = frmCliente.nome.value
	let cpf = frmCliente.cpf.value
	let login = frmCliente.login.value
	let senha = frmCliente.senha.value
	
	if (nome === "") {
		alert('O nome do cliente não pode ser vazio')
		frmCliente.nome.focus()
		return false
	} else if (cpf==="") {
		alert('O CPF do cliente não pode ser vazio')
		frmCliente.cpf.focus()
		return false
	} else if (login==="") {
		alert('O login do cliente não pode ser vazio')
		frmCliente.login.focus()
		return false
	} else if (senha==="") {
		alert('A senha do cliente não pode ser vazio')
		frmCliente.senha.focus()
		return false
	} else {
		document.forms["frmCliente"].submit()
	}
} 

 