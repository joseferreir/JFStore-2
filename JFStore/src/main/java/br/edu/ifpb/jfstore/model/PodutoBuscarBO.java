/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.jfstore.model;

import br.edu.ifpb.jfstore.DAO.produtoDAOif;
import br.edu.ifpb.jfstore.entidades.Produto;
import br.edu.ifpb.jfstore.factoy.Factory;

import java.util.List;

/**
 * Classe das regras de negocio para busca de produtos
 *
 * @author José
 */
public class PodutoBuscarBO {

    private produtoDAOif dao;

    public PodutoBuscarBO() {
        dao = Factory.criarFactoy(Factory.DAO_BD).criarProdutoDAO();
    }

    /**
     * métodos útiu para a buscar um objeto produto
     *
     * @param id id do produto desejado
     * @return retorna um ojeto poduto que tenha id iqual ao id informado. casa
     * não seja encontrado produto com esse id retorna null
     *
     */
    public Produto buscaporId(int id) {
        return dao.buscaporId(id);
    }

    /**
     * métodos útiu para a buscar um objeto produto
     *
     * @param categoria categoria do produto
     * @return retorna uma lista de objetos produto que pertença a categoria
     * informada.
     */
 public List<Produto> buscaporCategoria(String categoria) {
        return dao.buscaporCategoria(categoria);
    }

    /**
     * métodos útiu para a buscar um objeto produto
     *
     * @param nome nome de um produto
     * @return retorna uma lista de produto que atenda ao nome informado casa não seja
     * encontrado um objeto com o nome informado retorna null
     */
  public List<Produto> buscaporNome(String nome) {
        return dao.buscaporNome(nome);
    }

    /**
     * Método que rerorna os produtos disponiveis para venda
     *
     * @return lista de objetos do tipo produto.
     * @see Produto
     */
  public List<Produto> buscaporDisponiveis() {
        return dao.buscaporDisponiveis();
    }

}
