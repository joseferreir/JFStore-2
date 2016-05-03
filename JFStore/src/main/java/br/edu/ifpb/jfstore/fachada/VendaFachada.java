/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.jfstore.fachada;

import br.edu.ifpb.jfstore.entidades.Venda;
import br.edu.ifpb.jfstore.model.VendaCadastrarBO;
import java.util.Map;

/**
 *
 * @author José
 */
public class VendaFachada {

    private VendaCadastrarBO cadastrar;

    public VendaFachada() {
    }

    public Map<String, String> cadastra(Venda venda) {
        if (cadastrar == null) {
            cadastrar = new VendaCadastrarBO();
        }
        return cadastrar.cadastra(venda);
    }
}
