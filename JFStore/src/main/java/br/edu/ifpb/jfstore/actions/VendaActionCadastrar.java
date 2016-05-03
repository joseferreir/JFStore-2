/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.jfstore.actions;

import br.edu.ifpb.jfstore.entidades.Produto;
import br.edu.ifpb.jfstore.entidades.Usuario;
import br.edu.ifpb.jfstore.entidades.Venda;
import br.edu.ifpb.jfstore.fachada.VendaFachada;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author José
 */
public class VendaActionCadastrar implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Usuario cliente = (Usuario) request.getSession().getAttribute("usuario");
        List<Produto> carrinho = (List<Produto>) request.getSession().getAttribute("carrinhoCompras");
        if (cliente == null || carrinho.isEmpty()) {
            request.getServletContext().getRequestDispatcher("/home.jsp");
        } else {
            Venda venda = new Venda(cliente);
            venda.setProdutos(carrinho);
            VendaFachada fachada = new VendaFachada();
            Map<String, String> resultado = fachada.cadastra(venda);
            if (resultado.get("passou").equals("true")) {
                resultado.put("resultado", "Compra finalizada com sucesso");
                request.getSession().setAttribute("resultado", resultado);
                request.getServletContext().getRequestDispatcher("/home.jsp");

            }

        }
    }

}
