/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.jfstore.model;

import br.edu.ifpb.jfstore.entidades.Venda;
import java.util.HashMap;
import java.util.Map;

/**
 * Classe que verifica os dados de venda
 * @author José
 */
public class VendaValidarBO {

    public VendaValidarBO() {
    }
    /*
     *  Verifica se o dados de uma venda são válidos segundo regras de negócio.
 * <p>
 * Retorna um Map<String,String> cujas chaves representam os campos com problema
 * e os valores são mensagens de erro explicativas. Quando a verificação ocorre
 * sem erros, um Map vazio é devolvido. Se for informado uma venda nulo, o
 * serviço também devolve um Map nulo.
    */
      public Map<String, String> validar(Venda v) {
        Map<String, String> resultado = new HashMap<>();
        if(v.getCliente()== null)
            resultado.put("cliente", "Infome o dono da compra");
        if(v.getCodigo().length()==0)
            resultado.put("codgo", "Erro no codigo da compra");
        if(v.getProdutos().isEmpty())
            resultado.put("carrinho", "Seu carrinha de conpra está vazio");
        if(resultado.isEmpty())
            resultado.put("passou", "true");
        else
            resultado.put("passou", "false");
        return resultado;
      }
}
