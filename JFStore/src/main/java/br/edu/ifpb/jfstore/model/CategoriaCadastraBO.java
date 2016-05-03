/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.jfstore.model;

import br.edu.ifpb.jfstore.entidades.Categoria;
import br.edu.ifpb.jfstore.factoy.Factory;

/**
 *
 * @author José
 */
public class CategoriaCadastraBO {

    public CategoriaCadastraBO() {
    }
    
    public boolean  cadastrar(Categoria c){
        if(c.getNome().trim().isEmpty()){
            boolean cadastrou = Factory.criarFactoy(Factory.DAO_BD).criarCategoriaDAO().add(c);
            if(cadastrou)
                return cadastrou;
        }
            
       return false;
    }
}
