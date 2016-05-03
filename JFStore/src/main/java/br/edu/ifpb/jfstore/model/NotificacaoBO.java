/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.jfstore.model;

import br.edu.ifpb.jfstore.entidades.NotificacaoPorEmail;
import br.edu.ifpb.jfstore.entidades.Usuario;

/**
 *
 * @author José
 * classe que envia informações aos usuários do sistema.
 */
public class NotificacaoBO {
    
    private  NotificacaoPorEmail email;

    public NotificacaoBO() {
          if(email== null)
          email=  new NotificacaoPorEmail();
    }
    /**
     * método que informa por email; Ao usuario que seu cadastro foi realizado com sucesso.
     * @param destinatario  obijeto da classe usuário
     * @return náo a retorno.
     */
    public void notificarCadastro(Usuario destinatario){
         String[] mensagem ={"Cadastro efetuado com sucesso","Olá "+destinatario.getNome()+" seja bem vindo a JFStore aproveite nossos produtos"};
    email.enviarEmail(destinatario.getEmail(), mensagem);
    }
    /**
     *  método que informa por email; Ao usuario que sua compra foi realizado com sucesso.
     * @param destinatario obijeto da classe usuário
     * @param codigoCompra código da compra realizada
     */
     public void notificarConfirmacaoDeCompra(Usuario destinatario,String codigoCompra){
         String[] mensagem ={"Compra efetuado com sucesso","Olá "+destinatario.getNome()+" sua compra foi registrada em nosso sistema,Acompanhar seu pedido utilize o código da compra"+"\n"+"código "+codigoCompra};
         email.enviarEmail(destinatario.getEmail(), mensagem);
    }
    
}
