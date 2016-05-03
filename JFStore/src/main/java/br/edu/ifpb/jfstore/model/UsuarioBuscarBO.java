/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.jfstore.model;

import br.edu.ifpb.jfstore.DAO.UsuarioDAO;
import br.edu.ifpb.jfstore.DAO.UsuarioDAOIF;
import br.edu.ifpb.jfstore.entidades.Usuario;
import br.edu.ifpb.jfstore.factoy.Factory;

/**
 *
 * @author José
 */
public class UsuarioBuscarBO {

    private UsuarioDAOIF daoUsuario;

    public UsuarioBuscarBO() {
        daoUsuario = new UsuarioDAO();
    }

 public Usuario buscaporId(int id) {
        return daoUsuario.buscaporId(id);

    }

  public Usuario buscaporEmail(String email) {
        return daoUsuario.buscaporEmail(email);

    }
}
