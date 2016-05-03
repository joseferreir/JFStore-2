/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.jfstore.actions;

import br.edu.ifpb.jfstore.entidades.Usuario;
import br.edu.ifpb.jfstore.fachada.UsuarioFachada;
import com.google.gson.Gson;
import java.io.IOException;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author José
 */
public class UsuarioActionCadastrar implements Action {

    private UsuarioFachada fachada;
    
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession sessao = request.getSession();
        Usuario usuario = montarUsuario(request);
        Map<String, String> resultadoCadastro = null;
        if (fachada == null) {
            fachada = new UsuarioFachada();
        }
        try {
            resultadoCadastro = fachada.cadastrar(usuario);
            if (resultadoCadastro.get("passou").equalsIgnoreCase("true")) {
                int id = fachada.buscarPorEmail(usuario.getEmail()).getId();
                usuario.setId(id);
                sessao.setAttribute("usuario", usuario);
                
                         request.getServletContext().getRequestDispatcher("/home.jsp");
            } 
               
            
        } catch (Exception ex) {
            
            System.err.println(ex.getMessage());
            
        }
        resultadoCadastro.remove("passou");
       String json = new Gson().toJson(resultadoCadastro.values());
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        request.getSession().setAttribute("erros", json);
        response.sendRedirect("alert_error_model.jsp");
    }

    private Usuario montarUsuario(HttpServletRequest request) {
        Usuario u = new Usuario();
        u.setNome(request.getParameter("nome"));
        u.setEmail(request.getParameter("email"));
        u.setSenha(request.getParameter("senha"));
        return u;
    }
    
}
