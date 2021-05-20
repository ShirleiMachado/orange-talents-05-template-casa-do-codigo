package br.com.zupacademy.shirlei.casadocodigo.categoria;

import javax.validation.constraints.NotBlank;

public class NovaCategoriaRequest {

    @NotBlank
    private String nome;

    public Categoria converter(){
        return new Categoria(this.nome);
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return "NovaCategoriaRequest{" +
                "nome='" + nome + '\'' +
                '}';
    }
}
