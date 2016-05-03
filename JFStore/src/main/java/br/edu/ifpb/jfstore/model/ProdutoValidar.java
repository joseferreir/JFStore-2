/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.jfstore.model;

import br.edu.ifpb.jfstore.entidades.Produto;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 *Classe que verifica se os dado de um Objeto produto são validos
 * @author José
 */
public class ProdutoValidar {

    public ProdutoValidar() {
    }
    /**
 * Verifica se o dados de um usário são válidos segundo regras de negócio.
 * <p>
 * Retorna um Map<String,String> cujas chaves representam os campos com problema
 * e os valores são mensagens de erro explicativas. Quando a verificação ocorre
 * sem erros, um Map vazio é devolvido. Se for informado um Usuário nulo, o
 * serviço também devolve um Map nulo.
 *
 * @author Natarajan
 */
     public  Map<String, String> validar(Produto p) {

        Map<String, String> resultado = new HashMap<>();
        if(p.getCategoria().trim().isEmpty())
            resultado.put("categoria", "infome a categoria");
            if(p.getNome().trim().isEmpty())
                resultado.put("infome o nome", "Infome o nome do produto");
            if(p.getPreco()==null|| p.getPreco()== BigDecimal.ZERO)
                if(resultado.isEmpty())
                    resultado.put("passou", "true");
                else resultado.put("passou", "false");
            
        return resultado;
     }
}
