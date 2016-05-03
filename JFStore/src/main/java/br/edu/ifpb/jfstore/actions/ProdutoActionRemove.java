/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.jfstore.actions;

import br.edu.ifpb.jfstore.fachada.ProdutoFachada;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author José
 */
public class ProdutoActionRemove implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProdutoFachada fachada = new ProdutoFachada();
        Map<String, String> resultado = new HashMap<String, String>();
        int idProduto = Integer.parseInt(request.getParameter("dlProduto"));
        if (idProduto == 0) {
            resultado.put("produtoEx", "dados ivalidos");
        }
        if (fachada.remover(idProduto)) {

        } else {
            resultado.put("erro", "Erro ao ezcluir o produto verifique os dados e a conexão tente novamente");

        }
        request.setAttribute("erros", resultado);
        response.sendRedirect(request.getContextPath() + "/categorias.jsp");
    }

}
