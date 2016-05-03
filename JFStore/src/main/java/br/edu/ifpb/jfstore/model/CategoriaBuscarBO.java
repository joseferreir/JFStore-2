/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.jfstore.model;

import br.edu.ifpb.jfstore.entidades.Categoria;
import br.edu.ifpb.jfstore.factoy.Factory;
import java.util.List;

/**
 *
 * @author José
 */
public class CategoriaBuscarBO {

    public CategoriaBuscarBO() {
    }
    
          
    public Categoria buscaporNome(String nome) {
        return Factory.criarFactoy(Factory.DAO_BD).criarCategoriaDAO().buscaporNome(nome);
    }

    public Categoria buscaporid(int id) {
        return Factory.criarFactoy(Factory.DAO_BD).criarCategoriaDAO().buscaporid(id);
    }

    public List<Categoria> buscapoTodos() {
        return Factory.criarFactoy(Factory.DAO_BD).criarCategoriaDAO().buscapoTodos();
    }
}
