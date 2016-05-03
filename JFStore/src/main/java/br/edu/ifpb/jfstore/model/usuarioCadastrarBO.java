/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.jfstore.model;

import br.edu.ifpb.jfstore.DAO.UsuarioDAOIF;
import br.edu.ifpb.jfstore.entidades.Usuario;
import br.edu.ifpb.jfstore.factoy.Factory;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author José
 * Classe utilizada para cadastrar objetos Usuário
 */
public class usuarioCadastrarBO {
/**
 * recebe um objeto Usuário
 * @param Usuario 
 * @return Map<String,String> com o resultado da operação
    */
    public Map<String, String> cadastrar(Usuario u) {
        Map<String, String> resultado = new HashMap<>();
        UsuarioValidarBO validar = new UsuarioValidarBO();
        resultado = validar.validar(u);
        UsuarioDAOIF factory = Factory.criarFactoy(Factory.DAO_BD).criaUsuarioDAO();
        if (resultado.get("passou").equalsIgnoreCase("true") ) {
            boolean cadastrou = factory.add(u);
            if(cadastrou){
                NotificacaoBO notificar = new NotificacaoBO();
                notificar.notificarCadastro(u);
                return resultado;
            }
            
        } else {
            resultado.put("passou", "false");
        }
        return resultado;

    }
}
