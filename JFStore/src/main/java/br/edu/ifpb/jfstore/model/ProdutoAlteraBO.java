/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.jfstore.model;

import br.edu.ifpb.jfstore.entidades.Produto;
import br.edu.ifpb.jfstore.factoy.Factory;
import java.util.HashMap;
import java.util.Map;

/**
 * classe que implementa as regras de negocio alterar entidade produto
 * @author José
 */
public class ProdutoAlteraBO {

    public ProdutoAlteraBO() {
    }
    
     /**
     * metodo utilizado para alterar produto
     * @param p 
     * objeto da entidade produto
     * @return Map<String, String> os os rerros casa nao ocorra erros retorna um Map null
     * 
     */
      public  Map<String, String> alterar(Produto p) {

        Map<String, String> resultado = new HashMap<>();
          ProdutoValidar validar = new ProdutoValidar();
          resultado = validar.validar(p);
          boolean alterou = false;
          if(resultado.get("passou").equalsIgnoreCase("true"))
             alterou = Factory.criarFactoy(Factory.DAO_BD).criarProdutoDAO().alterar(p);
          if(alterou)
              return resultado;
          else resultado.put("passou", "false");
        return resultado;
      }
    
}
