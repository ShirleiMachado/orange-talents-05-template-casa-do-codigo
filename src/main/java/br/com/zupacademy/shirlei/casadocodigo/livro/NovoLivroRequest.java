package br.com.zupacademy.shirlei.casadocodigo.livro;

import br.com.zupacademy.shirlei.casadocodigo.validacoes.UniqueValue;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Column;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

public class NovoLivroRequest {

    @NotBlank
    @UniqueValue(domainClass = Livro.class, fieldName = "titulo",
            message = "Esse título já existe")
    private String titulo;

    @NotBlank
    @Size(max = 500)
    private String resumo;

    private String sumario;

    @NotNull
    @Min(20)
    private BigDecimal preco;

    @NotNull
    @Min(100)
    private Integer paginas;

    @NotBlank
    @UniqueValue(domainClass = Livro.class, fieldName = "ISBN", message = "Esse ISBN já existe")
    private String ISBN;

    @Future
    //@JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate dataPublicacao;

    @NotNull
    private Long idCategoria;

    @NotNull
    private Long idAutor;


    public NovoLivroRequest(@NotBlank String titulo,  @NotBlank @Size(max = 500) String resumo,
                            String sumario, @NotBlank @Min(20) BigDecimal preco,
                            @NotBlank  @Min(100) Integer paginas, @NotBlank String ISBN,
                            @NotNull Long idCategoria, @NotNull Long idAutor) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.paginas = paginas;
        this.ISBN = ISBN;
        this.idCategoria = idCategoria;
        this.idAutor = idAutor;
    }

    public Livro toModel(){
        return new Livro(
                this.titulo = titulo,
                this.resumo = resumo,
                this.sumario = sumario,
                this.preco = preco,
                this.paginas = paginas,
                this.ISBN = ISBN,
                this.dataPublicacao = dataPublicacao
        );
    }
}
