/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.jfstore.DAO;

import br.edu.ifpb.jfstore.conexao.Conexao;
import br.edu.ifpb.jfstore.conexao.ConexaoIF;
import br.edu.ifpb.jfstore.conexao.DataBaseException;
import br.edu.ifpb.jfstore.entidades.Produto;
import br.edu.ifpb.jfstore.entidades.Usuario;
import br.edu.ifpb.jfstore.entidades.Venda;
import java.io.IOException;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author José
 */
public class VendaDAO implements VendaDAOIF {

    private ConexaoIF conn;
    private PreparedStatement pst = null;
    private String sql;

    public VendaDAO() {
        try {
            this.conn = new Conexao();
        } catch (ClassNotFoundException | SQLException | IOException ex) {
            Logger.getLogger(VendaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public boolean add(Venda v) {
        sql = "INSERT INTO venda (codigo,idCliente,data) VALUES(?,?,?)";
        int erroadditens = 0;
        try {
            pst = conn.getConnection().prepareStatement(sql);

            pst.setInt(1, Integer.parseInt(v.getCodigo().toString()));
            pst.setInt(2, v.getCliente().getId());
            pst.setTimestamp(3, v.getData());

            if (pst.executeUpdate() > 0) {
                erroadditens = addItensVenda(v.getProdutos(), v.getCodigo().toString());

            } else {
                erroadditens = 1;
            }

        } catch (SQLException ex) {
            Logger.getLogger(VendaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                conn.closeAll(pst);
            } catch (DataBaseException ex) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (erroadditens == 0) {
            return true;
        } else {
            remover(v.getCodigo().toString());
        }
        return false;

    }

    @Override
    public boolean alterar(Venda v) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean remover(String codigo) {
        boolean result = false;
        try {
            sql = "DELETE FROM Venda WHERE codigo = '" + codigo + "'";
            conn = new Conexao();
            pst = conn.getConnection().prepareStatement(sql);
            if (pst.executeUpdate() > 0) {
                result = true;
            }
        } catch (SQLException | ClassNotFoundException | IOException e) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                conn.closeAll(pst);
            } catch (DataBaseException ex) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return result;
    }

    @Override
    public Usuario buscaporId(String codigo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private int addItensVenda(List<Produto> produtos, String codigoVenda) {
        sql = "INSERT INTO VendaProduto (codigoVenda,idProduto) VALUES(?,?)";
        boolean result = true;
        try {
            if (!produtos.isEmpty()) {
                while (!produtos.isEmpty() && result) {
                    pst = conn.getConnection().prepareStatement(sql);
                    int k = 0;
                    pst.setInt(1, Integer.parseInt(codigoVenda));
                    pst.setInt(2, produtos.get(k).getId());

                    if (pst.executeUpdate() > 0) {
                        result = true;
                        produtos.remove(k);
                        k++;
                    } else {
                        result = false;
                    }
                }
            }
        } catch (SQLException e) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                conn.closeAll(pst);
            } catch (DataBaseException ex) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (produtos.isEmpty()) {
            return 0;
        } else {
            return 1;
        }

    }

}
