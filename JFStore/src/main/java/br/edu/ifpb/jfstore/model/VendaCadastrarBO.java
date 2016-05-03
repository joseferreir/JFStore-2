/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.jfstore.model;

import br.edu.ifpb.jfstore.entidades.Produto;
import br.edu.ifpb.jfstore.entidades.Venda;
import br.edu.ifpb.jfstore.factoy.Factory;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author José
 */
public class VendaCadastrarBO {

    public VendaCadastrarBO() {
    }

    public Map<String, String> cadastra(Venda v) {
        Map<String, String> resultado;
        VendaValidarBO venda = new VendaValidarBO();
        resultado = venda.validar(v);
        if (resultado.get("passou").equals("true")) {
            boolean cadastrou = Factory.criarFactoy(Factory.DAO_BD).criarvendaDAO().add(v);
            if (cadastrou) {
                NotificacaoBO notificar = new NotificacaoBO();
                notificar.notificarConfirmacaoDeCompra(v.getCliente(), v.getCodigo().toString());
                return resultado;
            } else {
                resultado.put("finalizar", "Erro ao finalizar a compra");
                resultado.put("passou", "false");
            }
        }
        return resultado;
    }
}
