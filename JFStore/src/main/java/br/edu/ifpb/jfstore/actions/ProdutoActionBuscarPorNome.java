/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.jfstore.actions;

import br.edu.ifpb.jfstore.entidades.Produto;
import br.edu.ifpb.jfstore.fachada.ProdutoFachada;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author José
 */
public class ProdutoActionBuscarPorNome implements Action{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nome = request.getParameter("nomeProduto");
        ProdutoFachada fachada = new ProdutoFachada();
        List<Produto> produtos = fachada.buscaporNome(nome);
        request.setAttribute("produtos", produtos);
    }
    
}
