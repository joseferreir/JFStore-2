/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.jfstore.DAO;

import br.edu.ifpb.jfstore.entidades.Produto;
import br.edu.ifpb.jfstore.entidades.Usuario;
import br.edu.ifpb.jfstore.entidades.Venda;
import java.util.List;

/**
 * Interface dos metodos de venda
 *
 * @author José
 */
public interface VendaDAOIF {

    boolean add(Venda v);

    boolean alterar(Venda v);

    boolean remover(String codigo);

    Usuario buscaporId(String codigo);

}
