/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.jfstore.actions;

import br.edu.ifpb.jfstore.entidades.Produto;
import br.edu.ifpb.jfstore.fachada.ProdutoFachada;
import br.edu.ifpb.jfstore.factoy.Factory;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author José
 */
public class CarrinhoActionAddPproduto implements Action{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idProduto = Integer.parseInt(request.getParameter("idPro"));
        List<Produto> carrinho = (List<Produto>) request.getSession().getAttribute("carrinhoCompras");
        if(carrinho== null)
            carrinho = new ArrayList<Produto>();
        ProdutoFachada ProdutoFachada = new ProdutoFachada();
        Produto novoProduto =  ProdutoFachada.buscaporId(idProduto);
        if(novoProduto!=null && novoProduto.getQuantidade()<0)
            carrinho.add(novoProduto);
        response.sendRedirect("JFSTORE/ver/produto.do?idproduto=" +novoProduto.getId());
    }
    
}
