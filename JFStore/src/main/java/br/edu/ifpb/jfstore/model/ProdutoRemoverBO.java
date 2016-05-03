/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.jfstore.model;

import br.edu.ifpb.jfstore.factoy.Factory;

/**
 * classe útio para remover produtos
 * @author José
 */
public class ProdutoRemoverBO {
    /**
     * metodo para remover produtos
     * @param idProduto id produto a ser removido
     * @return  retorna true se a operação bem sucedida caso contrario retona false
     */
  public boolean remover(int idProduto){
   return  Factory.criarFactoy(Factory.DAO_BD).criarProdutoDAO().remover(idProduto);
  }
    
}
