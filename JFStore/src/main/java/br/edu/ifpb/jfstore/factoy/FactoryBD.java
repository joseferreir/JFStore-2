package br.edu.ifpb.jfstore.factoy;

import br.edu.ifpb.jfstore.DAO.*;

public class FactoryBD implements FactoryDAOIF {

    public FactoryBD() {
    }

    @Override
    public UsuarioDAOIF criaUsuarioDAO() {
        return new UsuarioDAO();

    }

    @Override
    public produtoDAOif criarProdutoDAO() {
       return new PodutoDAO();
    }

    @Override
    public VendaDAOIF criarvendaDAO() {
       return new VendaDAO();
    }

}
