INSERT INTO AUTOR(nome, email, descricao) VALUES('Brooke_Davis', 'brokie@email.com', 'Clothes Over Bros');
INSERT INTO AUTOR(nome, email, descricao) VALUES('Lucas_Scott', 'Scott@email.com', 'Neste momento há 6470818671 pessoas no mundo');
INSERT INTO AUTOR(nome, email, descricao) VALUES('Peyton_Sawyer', 'Sawyer@email.com', 'Sabe essa coisa de julgar um livro pela capa? É um fato. Às vezes, você já leu o livro todo e, ainda assim, não consegue saber a história toda');

INSERT INTO CATEGORIA(nome) VALUES('Infantil');
INSERT INTO CATEGORIA(nome) VALUES('Ficção');
INSERT INTO CATEGORIA(nome) VALUES('Auto Ajuda');
INSERT INTO CATEGORIA(nome) VALUES('Religioso');


INSERT INTO LIVRO(titulo, resumo, sumario, preco, paginas, ISBN, data_publicacao, Categoria_id, Autor_id) VALUES('Lógica de Programação e Estruturas de Dados','Esta terceira edição vem complementar as anteriores, mantendo uma linguagem didática','sumário','78.40',288,'8543019141', '2021-06-02', 2, 1)
/*INSERT INTO LIVRO(titulo, resumo, sumario, preco, paginas, ISBN, dataPublicacao, idCategoria, idAutor) VALUES('A Arte de ver o invisível','A arte de ver o invisível é tudo o que você precisa saber para acessar a vida que Deus te desenhou para ter.','sumário','25.50',160,'9786580363001', '13/09/2021', 4, 2)*/
