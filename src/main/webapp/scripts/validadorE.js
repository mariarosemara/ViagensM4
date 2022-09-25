function validarE() {
	let cnpj = frmEmpresa.cnpj.value
	let localidade = frmEmpresa.localidade.value
	let proprietario = frmEmpresa.proprietario.value
	let login = frmEmpresa.login.value
	let senha = frmEmpresa.senha.value
	
	if (cnpj === "") {
		alert('O CNPJ da empresa não pode ser vazio')
		frmEmpresa.cnpj.focus()
		return false
	} else if (localidade==="") {
		alert('A localidade da empresa não pode ser vazio')
		frmEmpresa.localidade.focus()
		return false
	}  else if (proprietario==="") {
		alert('O proprietario da empresa não pode ser vazio')
		frmEmpresa.proprietario.focus()
		return false
	}else if (login==="") {
		alert('O login da empresa não pode ser vazio')
		frmEmpresa.login.focus()
		return false
	} else if (senha==="") {
		alert('A senha da empresa não pode ser vazio')
		frmEmpresa.senha.focus()
		return false
	} else {
		document.forms["frmEmpresa"].submit()
	}
} 