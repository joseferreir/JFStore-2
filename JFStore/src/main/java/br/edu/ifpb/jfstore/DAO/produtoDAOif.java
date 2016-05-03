/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.jfstore.DAO;

import br.edu.ifpb.jfstore.entidades.Produto;
import br.edu.ifpb.jfstore.entidades.Usuario;
import java.util.List;

/**
 *
 * @author José
 * Interface que descreve os métodos referente a entidade produto. para interação com a base de dados
 * 
 */
public interface produtoDAOif {
/**
 * métodos útiu para  persistir um objeto produto na base de dados
 * @param Produto obijeto da classe produto
 * @return retorna true quando o operação é bem sucedida caso contrario retorna false
 */
    boolean add(Produto p);
/**
 * métodos útiu para a alterar um objeto produto na base de dados
 * @param Produto objeto da classe produto
 * @return retorna true quando o operação é bem sucedida caso contrario retorna false
 */
    boolean alterar(Produto p);
/**
 * métodos útiu para a apagar um objeto produto na base de dados
 * @param int id id do produto a ser apagado
 * @return retorna true quando o operação é bem sucedida caso contrario retorna false
 */
    boolean remover(int id);
/**
 * métodos útiu para a buscar um objeto produto na base de dados
 * @param id id do produto desejado
 * @return retorna um ojeto poduto que tenha id iqual ao id informado.
 * casa não seja encontrado produto com esse id retorna null
 * 
 */
    Produto buscaporId(int id);
/**
 *  métodos útiu para a buscar um objeto produto na base de dados
 * @param categoria categoria do produto
 * @return retorna uma lista de objetos produto que pertença  a categoria informada.
 */
   List<Produto> buscaporCategoria(String categoria);
/**
 *  métodos útiu para a buscar um objeto produto na base de dados
 * @param nome nome de um produto
 * @return retorna um lista de produto que atenda ao nome informado 
 * casa não seja encontrado um objeto com o nome informado retorna null
 */
    List<Produto> buscaporNome(String nome);
    /**
     * Método que rerorna os produtos disponiveis para venda
     * @return lista de objetos do tipo produto.
     * @see Produto
     */
     List<Produto> buscaporDisponiveis();

}
