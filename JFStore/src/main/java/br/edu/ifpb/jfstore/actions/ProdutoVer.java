/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.jfstore.actions;

import br.edu.ifpb.jfstore.entidades.Produto;
import br.edu.ifpb.jfstore.fachada.ProdutoFachada;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author José
 */
public class ProdutoVer implements Action{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       int id = Integer.parseInt(request.getParameter("idproduto"));
       if(id == 0)
            response.sendRedirect("/home");
        ProdutoFachada ProdutoFachada = new ProdutoFachada();
        Produto produto = ProdutoFachada.buscaporId(id);
        request.getSession().setAttribute("produto", produto);
          response.sendRedirect("/VerProduto.jsp");
        
    }
    
}
