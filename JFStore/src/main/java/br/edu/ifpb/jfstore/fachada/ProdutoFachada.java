/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.jfstore.fachada;

import br.edu.ifpb.jfstore.entidades.Produto;
import br.edu.ifpb.jfstore.model.PodutoBuscarBO;
import br.edu.ifpb.jfstore.model.ProdutoAlteraBO;
import br.edu.ifpb.jfstore.model.ProdutoCadastrarB0;
import br.edu.ifpb.jfstore.model.ProdutoRemoverBO;
import java.util.List;
import java.util.Map;

/**
 * classe fachada dos métodos para manipular obijetos do tipo produto
 *
 * @author José
 */
public class ProdutoFachada {

    private ProdutoCadastrarB0 cadastra;
    private PodutoBuscarBO buscar;
    private ProdutoAlteraBO altera;
    private ProdutoRemoverBO remover;

    public ProdutoFachada() {
    }

    /**
     * metodo utilizado para alterar produto
     *
     * @param p objeto da entidade produto
     * @return Map<String, String> os os rerros casa nao ocorra erros retorna um
     * Map null
     *
     */
    public Map<String, String> alterar(Produto p) {
        altera = new ProdutoAlteraBO();
        return altera.alterar(p);
    }

    /**
     * Método para cadastrar produtos
     *
     * @param produto objetos do tipo produto
     * @return Map
     */
    public Map<String, String> cadastrarProduto(Produto produto) {
        cadastra = new ProdutoCadastrarB0();
        return cadastra.cadastrar(produto);
    }
    
public boolean remover(int idProduto){
    remover = new ProdutoRemoverBO();
    return remover.remover(idProduto);
}
    /**
     * buscar por id
     *
     * @see ProdutoBuscarBO buscaporId(int id);
     * @param id
     * @return
     */
    Produto buscaporId(int id) {
        buscar = new PodutoBuscarBO();
        return buscar.buscaporId(id);
    }

    /**
     * busca uma lista de objetos da entiddade produto que o valor do atributo
     * categoria seja igual a o valor do parametro
     *
     * @param categoria
     * @return List<Produtos>
     */
    public List<Produto> buscaporCategoria(String categoria) {
        buscar = new PodutoBuscarBO();
        return buscar.buscaporCategoria(categoria);
    }

    public List<Produto> buscaporNome(String nome) {
        buscar = new PodutoBuscarBO();
        return buscar.buscaporNome(nome);
    }
    

    public List<Produto> buscaporDisponiveis() {
        buscar = new PodutoBuscarBO();
        return buscar.buscaporDisponiveis();
    }

}
