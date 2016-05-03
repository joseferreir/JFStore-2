/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.jfstore.entidades;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

/**
 * Classe que encapsula as informações de vendas do sistema
 *
 * @author José
 */
public class Venda {

    private StringBuilder codigo;
    private Timestamp data;
    private List<Produto> produtos;
    Usuario cliente;

    public Venda(Usuario u) {
        this.cliente = u;
        this.data = Timestamp.from(Instant.now());
        gerarCodigo();
    }

    public StringBuilder getCodigo() {
        return codigo;
    }

    public void setCodigo(StringBuilder codigo) {
        this.codigo = codigo;
    }

    public Timestamp getData() {
        return data;
    }

    public void setData(Timestamp data) {
        this.data = data;
    }

  

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public Usuario getCliente() {
        return cliente;
    }

    public void setCliente(Usuario cliente) {
        this.cliente = cliente;
    }

    private void gerarCodigo() {
        this.codigo = new StringBuilder();

        if (cliente.getId() < 10) {
            codigo.append("0");
        }
        codigo.append(cliente.getId());

        int segundos = this.data.getSeconds();
        
     if(segundos<10)
         codigo.append(0);
        codigo.append(segundos);
        
        int dia = data.getDay();
        dia++;
        if (dia < 10) {
            codigo.append(0);
        }
        codigo.append(dia);
        Random gerador = new Random();
        int alt = gerador.nextInt(100);
        if(alt<0)
        codigo.append(0);
        codigo.append(alt);

    }

    @Override
    public String toString() {
        return "Venda{" + "codigo=" + codigo + ", data=" + data + ", cliente=" + cliente + '}';
    }

}
