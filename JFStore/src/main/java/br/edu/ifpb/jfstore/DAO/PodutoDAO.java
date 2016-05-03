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
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author José classe que realiza as operações referentes a entidade produto na
 * base de dados
 */
public class PodutoDAO implements produtoDAOif {

    private ConexaoIF conn;
    private PreparedStatement pst = null;
    private String sql;
    private final int addProduto = 0;
    private final int setProduto = 1;

    public PodutoDAO() {
        try {
            this.conn = new Conexao();
        } catch (SQLException | IOException | ClassNotFoundException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public boolean add(Produto p) {
        sql = "INSERT INTO Produto (nome,quantidade,categoria,preco,imagem) VALUES(?,?,?,?,?)";
        return persinteNoBD(p, sql, addProduto);
    }

    @Override
    public boolean alterar(Produto p) {
        sql = "UPDATE Produto SET nome=?,quantidade=?,categoria=?,preco=?,imagem=? WHERE id=?";
        return persinteNoBD(p, sql, setProduto);
    }

  
    @Override
    public Produto buscaporId(int id) {
        sql = "SELECT * FROM Produto WHERE id ='" + id + "'";
        return bucarNoBD(sql).get(0);
    }

    @Override
    public List<Produto> buscaporCategoria(String categoria) {
        sql = "SELECT * FROM Produto WHERE categoria ='" + categoria + "'";
        return bucarNoBD(sql);
    }

    @Override
    public List<Produto> buscaporNome(String nome) {
        sql = "SELECT * FROM Usuario WHERE nomeCompleto ilike '%" + nome + "%'";
        return bucarNoBD(sql);
    }

  
    @Override
    public List<Produto> buscaporDisponiveis() {
 sql = "SELECT * FROM Produto WHERE quantidade >0";
        return bucarNoBD(sql);
    }
  @Override
    public boolean remover(int id) {
        boolean result = false;
        try {
            sql = "DELETE FROM Produto WHERE id = '" + id + "'";
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

    
    private boolean persinteNoBD(Produto p, String sql, int operacao) {
        boolean result = false;
        try {
            conn = new Conexao();

            pst = conn.getConnection().prepareStatement(sql);

            pst.setString(1, p.getNome());
            pst.setInt(2, p.getQuantidade());
            pst.setString(3, p.getCategoria());
            pst.setDouble(4, p.getPreco().doubleValue());
            pst.setString(5, p.getImagem());

            if (operacao == setProduto) {
                pst.setInt(6, p.getId());
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

    /**
     * Método útio para buscar produtos no banco de dados
     *
     * @param sql Definr os criterios de busca para os produtos
     * @return retorna uma lista de objetos produtos casa não seja encontrado
     * objetos produto que atenda a os criterios definidos na sql retorna null
     */

    private List<Produto> bucarNoBD(String sql) {
        List<Produto> produtos = new ArrayList<>();
        try {

            pst = conn.getConnection().prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                produtos.add(montarProduto(rs));

            }
            if (produtos.isEmpty()) {
                produtos = null;
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
        return produtos;
    }

    private Produto montarProduto(ResultSet rs) throws SQLException {
        Produto p = new Produto();
        p.setCategoria(rs.getString("categoria"));
        p.setId(rs.getInt("id"));
        p.setImagem(rs.getString("imagem"));
        p.setNome(rs.getString("nome"));
        p.setPreco(BigDecimal.valueOf(rs.getDouble("preco")));
        p.setQuantidade(rs.getInt("quantidade"));
        return p;

    }

}
