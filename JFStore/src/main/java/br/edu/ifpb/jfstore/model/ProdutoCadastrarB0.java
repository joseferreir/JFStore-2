/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.jfstore.model;

import br.edu.ifpb.jfstore.DAO.PodutoDAO;
import br.edu.ifpb.jfstore.entidades.Produto;
import br.edu.ifpb.jfstore.factoy.Factory;
import java.util.HashMap;
import java.util.Map;

/**
 * Classe que encapsula as regras de negocio para cadastra objetos da entidade produto
 * @author José
 */
public class ProdutoCadastrarB0 {
    /**
     * metodo utilizado para cadastrar produto
     * @param p 
     * objeto da entidade produto
     * @return Map<String, String> os os rerros casa nao ocorra erros retorna um Map null
     * 
     */
      public  Map<String, String> cadastrar(Produto p) {

        Map<String, String> resultado = new HashMap<>();
          ProdutoValidar validar = new ProdutoValidar();
          resultado = validar.validar(p);
          boolean cadastrou = false;
          if(resultado.get("passou").equalsIgnoreCase("true"))
             cadastrou = Factory.criarFactoy(Factory.DAO_BD).criarProdutoDAO().add(p);
          if(cadastrou)
              return resultado;
          else resultado.put("passou", "false");
        return resultado;
      }
}
