package br.com.zupacademy.shirlei.casadocodigo.validarErros;

public class Erro {

	private String fild;
	private String erro;

	public Erro(String campo, String erro) {
		this.fild = campo;
		this.erro = erro;
	}

	public String getCampo() {
		return fild;
	}
	public String getErro() {
		return erro;
	}



}
