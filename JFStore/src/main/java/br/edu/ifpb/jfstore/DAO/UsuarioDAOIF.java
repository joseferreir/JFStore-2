/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.jfstore.DAO;

import br.edu.ifpb.jfstore.entidades.Usuario;

/**
 *
 * @author José
 */
public interface UsuarioDAOIF {

    boolean add(Usuario u);

    boolean alterar(Usuario u);

    boolean remover(int id);

    Usuario buscaporId(int id);

    Usuario buscaporEmail(String email);

    Usuario buscaporSenha(String senha);

    Usuario login(String email, String senha);

}
