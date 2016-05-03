/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.jfstore.factoy;

import br.edu.ifpb.jfstore.DAO.*;


/**
 *
 * @author José
 */
public interface FactoryDAOIF {

    UsuarioDAOIF criaUsuarioDAO();
    produtoDAOif criarProdutoDAO();
    VendaDAOIF criarvendaDAO();

}
