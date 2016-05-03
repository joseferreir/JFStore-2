/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.jfstore.teste;

import br.edu.ifpb.jfstore.DAO.produtoDAOif;
import br.edu.ifpb.jfstore.entidades.Produto;
import br.edu.ifpb.jfstore.entidades.Usuario;
import br.edu.ifpb.jfstore.entidades.Venda;
import br.edu.ifpb.jfstore.factoy.Factory;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author José
 */
public class Teste {
    public static void main(String[] args) throws IOException, URISyntaxException {
       // UsuarioFachada fachada = new UsuarioFachada();
            //    Usuario u = new Usuario();
              //  u.setNome("maria");
                //u.setEmail("joseifpb2015@gmail.com");
                //u.setSenha("ma1234");
        produtoDAOif ff = Factory.criarFactoy(Factory.DAO_BD).criarProdutoDAO();
        //   System.err.println("result" + ff.getNome()) ;
              
                System.err.println("cccccc");
        //  Map<String, String> res = fachada.cadastrar(u);
        //  System.err.println("resultado "+res.values());
                
           //     String[] mensagem ={"Cadastro efetuado com sucesso","Olá "+u.getNome()+" ceja bem vindo a JFSStore aproveite nossos produtos"};
        // NotificacaoBO notificar = new NotificacaoBO();
        //notificar.notificarConfirmacaoDeCompra(u,215554);
        Produto p = new Produto();
        p.setNome("produto 3");
        p.setCategoria("informatica /p");
        p.setImagem("/ddek");
        p.setPreco(BigDecimal.valueOf(122));
        p.setQuantidade(13);
        p.setId(2);
        Usuario c = new Usuario();
        c.setId(10);
        c.setNome("jose");
        c.setEmail("joseifpb2015@gmail.com");
        Venda v = new Venda(c);
        v.setCliente(c);
        System.err.println("xxx "+v.getCodigo());
        System.err.println("data "+v.getData());
        List<Produto> ps = new ArrayList<>();
        ps.add(p);
        v.setProdutos(ps);
     //  boolean rr = Factory.criarFactoy(0).criarvendaDAO().add(v);
       // NotificacaoBO n = new NotificacaoBO();
      //  n.notificarCadastro(c);
        
   //   System.err.println("venda "+rr);
                
                  
      
        


      
    }
    
}
