package br.com.zupacademy.shirlei.casadocodigo.livro;

import br.com.zupacademy.shirlei.casadocodigo.autor.Autor;
import br.com.zupacademy.shirlei.casadocodigo.categoria.Categoria;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String titulo;

    @NotBlank @Size(max = 500)
    private String resumo;

    private String sumario;

    @NotNull
    private BigDecimal preco;

    @NotNull @Min(100)
    private Integer paginas;

    @NotBlank
    private String ISBN;

    @Future
    private LocalDate dataPublicacao;

    @ManyToOne
    private Categoria categoria;

    @ManyToOne
    private Autor autor;

    public Livro(){};

    public Livro(String titulo, String resumo, String sumario, BigDecimal preco, Integer paginas,
                 String ISBN, LocalDate dataPublicacao){
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.paginas = paginas;
        this.ISBN = ISBN;
        this.dataPublicacao = dataPublicacao;
    }
}
