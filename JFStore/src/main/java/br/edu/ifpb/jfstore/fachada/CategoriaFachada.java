/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.jfstore.fachada;

import br.edu.ifpb.jfstore.entidades.Categoria;
import br.edu.ifpb.jfstore.model.CategoriaBuscarBO;
import br.edu.ifpb.jfstore.model.CategoriaCadastraBO;
import java.util.List;

/**
 *
 * @author José
 */
public class CategoriaFachada {
    private CategoriaCadastraBO categoriacadastrar = new CategoriaCadastraBO();
    private CategoriaBuscarBO categoriaBuscar = new CategoriaBuscarBO();

    public CategoriaFachada() {
    }

    public Categoria buscaporNome(String nome) {
        return categoriaBuscar.buscaporNome(nome);
    }

    public Categoria buscaporid(int id) {
        return categoriaBuscar.buscaporid(id);
    }

    public List<Categoria> buscapoTodos() {
        return categoriaBuscar.buscapoTodos();
    }

    private boolean cadastrar(Categoria c) {
        return categoriacadastrar.cadastrar(c);
    }

}
