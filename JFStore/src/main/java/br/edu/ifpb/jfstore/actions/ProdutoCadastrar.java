/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.jfstore.actions;

import br.edu.ifpb.jfstore.entidades.Produto;
import br.edu.ifpb.jfstore.entidades.Usuario;
import br.edu.ifpb.jfstore.fachada.ProdutoFachada;
import br.edu.ifpb.jfstore.model.ProcessadorFotos;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * classe que encapsula os comandos para cadastrar um novo produto
 * @author José
 */
public class ProdutoCadastrar  implements Action{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        try {
             Usuario usuario = (Usuario) request.getAttribute("usuario");
             ProdutoFachada fachada = null;
             if(!usuario.getTipo())
                  response.sendRedirect(request.getContextPath() + "/home");
             else
                  fachada = new ProdutoFachada();
             Map<String, String> resultado = fachada.cadastrarProduto(montarProduto(request));
             if(resultado.get("passou").equals("true")){
                 resultado.remove("passou");
                 response.sendRedirect(request.getContextPath() + "/categorias.jsp");
             }
             resultado.remove("passou");
             request.getSession().setAttribute("erros", resultado.values());
              response.sendRedirect(request.getContextPath() + "/categorias.jsp");
              
                 
        } catch (Exception e) {
        }
                
    }
    private Produto montarProduto(HttpServletRequest request) throws IOException, IllegalStateException, ServletException{
        Produto p = new Produto();
         Part capaPart = request.getPart("imagem");
        String nomeArquivo = capaPart.getName();
        if (nomeArquivo == null || nomeArquivo == "")
            nomeArquivo = "img/produtos/capa_default.jpg";
        String nome = request.getParameter("isbn");
        String capa = new ProcessadorFotos("img/produtos").processarArquivoCapa(request, capaPart, "capa" + nome + nomeArquivo);
        p.setImagem(capa);
        p.setCategoria(request.getParameter("categoria"));
        p.setNome(nome);
        double preco = Double.parseDouble(request.getParameter("preco"));
        p.setPreco(BigDecimal.valueOf(preco));
        p.setQuantidade(Integer.parseInt(request.getParameter("quantidade")));
        return p;
        
    }
    
}
