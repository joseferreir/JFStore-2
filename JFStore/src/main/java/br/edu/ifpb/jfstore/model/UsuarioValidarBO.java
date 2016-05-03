/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.jfstore.model;

import br.edu.ifpb.jfstore.DAO.UsuarioDAOIF;
import br.edu.ifpb.jfstore.entidades.Usuario;
import br.edu.ifpb.jfstore.factoy.FactoryDAOIF;
import br.edu.ifpb.jfstore.factoy.Factory;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/**

 * @author José
 */
public class UsuarioValidarBO {
/*
     *  Verifica se o dados de um usário são válidos segundo regras de negócio.
 * <p>
 * Retorna um Map<String,String> cujas chaves representam os campos com problema
 * e os valores são mensagens de erro explicativas. Quando a verificação ocorre
 * sem erros, um Map vazio é devolvido. Se for informado um Usuário nulo, o
 * serviço também devolve um Map nulo.
    */
    public UsuarioValidarBO() {
    }
    

    public static final Pattern REGEX_EMAIL_VALIDO = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
    FactoryDAOIF factoy = Factory.criarFactoy(Factory.DAO_BD);

    public Map<String, String> validar(Usuario u) {
        Map<String, String> resultado = new HashMap<>();

        if (u == null) {
            return null;
        }

        if (u.getNome() == null || u.getNome().trim().isEmpty()) {
            resultado.put("nome", "Informe seu nome.");
        } else if (!u.getNome().matches("[A-Za-zÀ-ú0-9 ]+")) {
            resultado.put("nome", "Nome não pode conter caracteres especiais (% - $ _ # @, por exemplo).");
        }
        if (u.getEmail() == null
                || u.getEmail().trim().isEmpty()
                || !REGEX_EMAIL_VALIDO.matcher(u.getEmail()).find()) {
            resultado.put("email", "Informe um email válido.");
        } else {

            Usuario usuarioEmail = factoy.criaUsuarioDAO().buscaporEmail(u.getEmail());
            if (usuarioEmail != null) {
                resultado.put("emailJaExiste", "Já existe um usuário cadastro com este email informado.");
            }
        }
        Usuario senhaExistente = null;

        if (u.getSenha().trim().isEmpty()) {
            resultado.put("senha", "Informe sua senha.");
        } else {
            senhaExistente = factoy.criaUsuarioDAO().buscaporSenha(u.getSenha());
        }
        if (senhaExistente != null) {
            resultado.put("senhaExistente", "A senha informada já existe");
        }
            if (resultado.isEmpty()) {
                resultado.put("passou", "true");
            } else {
                resultado.put("passou", "false");
            }
        

        return resultado;
    }
}
