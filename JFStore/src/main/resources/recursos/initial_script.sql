

/*
table Usuário */
CREATE TABLE Usuario(
    id SERIAL,
    Nome VARCHAR(100) UNIQUE NOT NULL, 
    email VARCHAR(50) UNIQUE NOT NULL,
    senha VARCHAR(32) NOT NULL,
    eh_admin BOOLEAN DEFAULT 'FALSE',
    PRIMARY KEY(id)

);


-- table Produto
CREATE TABLE Produto(
    id SERIAL,
    nome VARCHAR(50) NOT NULL,
    quantidade INTEGER NOT NULL,
    Categoria VARCHAR(50) NOT NULL,
    preco DOUBLE PRECISION NOT NULL,
    imagem VARCHAR(100) NOT NULL,
    PRIMARY KEY(id)
);


/*
table venda

*/
CREATE TABLE Venda (
    codigo INTEGER,
    idCliente INTEGER NOT NULL,
    data TIMESTAMP NOT NULL,
    FOREIGN KEY (idCliente) REFERENCES usuario (id) ON DELETE SET NULL,
    PRIMARY KEY(codigo)
);
CREATE TABLE VendaProduto (
    idProduto INTEGER NOT NULL,
    codigoVenda INTEGER NOT NULL,
    FOREIGN KEY (codigoVenda) REFERENCES  venda(codigo) ON DELETE CASCADE,
    FOREIGN KEY (idProduto) REFERENCES  produto(id) ON DELETE CASCADE,
    PRIMARY KEY(codigoVenda,idProduto)
);

