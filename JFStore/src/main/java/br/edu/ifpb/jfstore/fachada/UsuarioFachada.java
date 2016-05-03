/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.jfstore.fachada;

import br.edu.ifpb.jfstore.entidades.Usuario;
import br.edu.ifpb.jfstore.model.UsuarioBuscarBO;
import br.edu.ifpb.jfstore.model.usuarioCadastrarBO;
import java.util.Map;

/**
 *
 * @author José classe que encapsuala as funcionalidade dos ojetos usuário
 */
public class UsuarioFachada {

 
    private usuarioCadastrarBO Cadastrar;
    private UsuarioBuscarBO buscar;

    public UsuarioFachada() {
    }
    
/**
 * método da fachado de usuário utilizado para cadastrar novos usuàrios
    */
    public Map<String, String> cadastrar(Usuario usuario) {
        if(Cadastrar == null)
        Cadastrar = new usuarioCadastrarBO();
        return Cadastrar.cadastrar(usuario);

    }
    /**
     * método da fachado de usuário utilizado para buscar novos usuàrio
     * @param String email
     * @return Usuario
     * 
     */
    public Usuario buscarPorEmail(String email){
        if(buscar == null)
            buscar= new UsuarioBuscarBO();
        return buscar.buscaporEmail(email);
    }

}
