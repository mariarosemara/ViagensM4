function validarD() {
	let nome = frmDestino.nome.value
	let valor = frmDestino.valor.value
	let localidade = frmDestino.localidade.value
	let proprietario = frmDestino.proprietario.value
	
	if (nome === "") {
		alert('O nome do destino não pode ser vazio')
		frmDestino.nome.focus()
		return false
	} else if (valor==="") {
		alert('O CPF do destino não pode ser vazio')
		frmDestino.valor.focus()
		return false
	} else if (localidade==="") {
		alert('A localidade do destino não pode ser vazio')
		frmDestino.localidade.focus()
		return false
	} else if (proprietario==="") {
		alert('O nome do proprietário do destino não pode ser vazio')
		frmDestino.proprietario.focus()
		return false
	} else {
		document.forms["frmDestino"].submit()
	}
} 
