/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.jfstore.DAO;

import br.edu.ifpb.jfstore.conexao.Conexao;
import br.edu.ifpb.jfstore.conexao.ConexaoIF;
import br.edu.ifpb.jfstore.conexao.DataBaseException;
import br.edu.ifpb.jfstore.entidades.Categoria;
import br.edu.ifpb.jfstore.entidades.Usuario;
import br.edu.ifpb.jfstore.entidades.Venda;
import br.edu.ifpb.jfstore.fachada.ProdutoFachada;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author José
 */
public class CategoriaDAO implements CategoriaDAOi {

    private ConexaoIF conn;
    private PreparedStatement pst = null;
    private String sql;
    private final int addCategoria = 0;
    private final int setCategoria = 1;

    public CategoriaDAO() {
        try {
            this.conn = new Conexao();
        } catch (SQLException ex) {
            Logger.getLogger(CategoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CategoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CategoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private boolean persinteNoBD(Categoria c, String sql, int operacao) {
        boolean result = false;
        try {
            conn = new Conexao();

            pst = conn.getConnection().prepareStatement(sql);

            pst.setString(1, c.getNome());
            if (operacao == setCategoria) {
                pst.setInt(2, c.getId());
            }
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
    public boolean add(Categoria c) {
        sql = "INSERT INTO Categoria(categoria) VALUES(?)";
        return persinteNoBD(c, sql, addCategoria);

    }

    @Override
    public boolean alterar(Categoria c) {
        sql = "UPDATE Categoria  SET nome=? WHERE id=?";
        return persinteNoBD(c, sql, setCategoria);
    }

    @Override
    public boolean remover(int id) {
        boolean result = false;
        try {
            sql = "DELETE FROM Categoria WHERE id = '" + id + "'";
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
    public Categoria buscaporNome(String nome) {
        sql = "SELECT * FROM Categoria WHERE categoria ='" + nome + "'";
        return bucarNoBD(sql).get(0);
    }

    @Override
    public Categoria buscaporid(int id) {
        sql = "SELECT * FROM Categoria WHERE id ='" + id + "'";
        return bucarNoBD(sql).get(0);
    }

    @Override
    public List<Categoria> buscapoTodos() {
        sql = "SELECT * FROM Categoria";
        return bucarNoBD(sql);
    }

    private List<Categoria> bucarNoBD(String sql) {
        List<Categoria> categoria = new ArrayList<>();
        try {

            pst = conn.getConnection().prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                categoria.add(montarCategoria(rs));

            }
         //   if(usuarios.isEmpty())
            // return null;

        } catch (SQLException e) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                conn.closeAll(pst);
            } catch (DataBaseException ex) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return categoria;
    }

    private Categoria montarCategoria(ResultSet rs) throws SQLException {
        String nome = rs.getString("categoria");
        Categoria c = new Categoria(nome);
        ProdutoFachada ProdutoFachada = new ProdutoFachada();
        c.setProdutos(ProdutoFachada.buscaporCategoria(nome));
        return c;

    }
}
