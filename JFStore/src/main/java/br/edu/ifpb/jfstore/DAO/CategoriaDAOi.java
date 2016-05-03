/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.jfstore.DAO;

import br.edu.ifpb.jfstore.entidades.Categoria;
import br.edu.ifpb.jfstore.entidades.Usuario;
import br.edu.ifpb.jfstore.entidades.Venda;
import java.util.List;

/**
 *
 * @author José
 */
public interface CategoriaDAOi {

    boolean add(Categoria c);

    boolean alterar(Categoria c);

    boolean remover(int id);

    Categoria buscaporNome(String nome);

    Categoria buscaporid(int id);

   List<Categoria> buscapoTodos();

}
