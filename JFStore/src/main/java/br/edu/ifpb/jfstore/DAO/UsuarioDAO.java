/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.jfstore.DAO;

import br.edu.ifpb.jfstore.conexao.Conexao;
import br.edu.ifpb.jfstore.conexao.ConexaoIF;
import br.edu.ifpb.jfstore.conexao.DataBaseException;
import br.edu.ifpb.jfstore.entidades.Usuario;
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
public class UsuarioDAO implements UsuarioDAOIF {

    private ConexaoIF conn;
    private PreparedStatement pst = null;
    private String sql;
    private final int addUsuario = 0;
    private final int setusuario = 1;

    public UsuarioDAO() {
        try {
            this.conn = new Conexao();
        } catch (SQLException | IOException | ClassNotFoundException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public boolean add(Usuario u) {
        sql = "INSERT INTO Usuario (nome,email,senha) VALUES(?,?,?)";
        return persinteNoBD(u, sql, addUsuario);
    }

    @Override
    public boolean alterar(Usuario u) {
        sql = "UPDATE Usuario SET nome=?,email=?,senha=? WHERE id=?";
        return persinteNoBD(u, sql, setusuario);
    }

    @Override
    public boolean remover(int id) {
        boolean result = false;
        try {
            sql = "DELETE FROM usuario WHERE id = '" + id + "'";
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
    public Usuario buscaporId(int id) {
        sql = "SELECT * FROM Usuario WHERE id ='" + id + "'";
        return bucarNoBD(sql).get(0);
    }

    @Override
    public Usuario buscaporEmail(String email) {
        sql = "SELECT *FROM Usuario WHERE email ='"+email+ "'";
        Usuario resultado = bucarNoBD(sql).get(0);
        if(resultado.getTipo())
            return null;
        return resultado;

    }

    public Usuario buscaporSenha(String senha) {
        sql = "SELECT * FROM Usuario WHERE senha ='" + senha + "'";
        List<Usuario> result = bucarNoBD(sql);
        if(result.isEmpty() )
            return null;
            return result.get(0);
    }

    @Override
    public Usuario login(String email, String senha) {
        sql = "SELECT * Usuario WHERE email = '" + email + "' AND senha ='" + senha + "'";
        return bucarNoBD(sql).get(0);
    }

    private boolean persinteNoBD(Usuario u, String sql, int operacao) {
        boolean result = false;
        try {
            conn = new Conexao();

            pst = conn.getConnection().prepareStatement(sql);

            pst.setString(1, u.getNome());
            pst.setString(2, u.getEmail());
            pst.setString(3, u.getSenha());

            if (operacao == setusuario) {
                pst.setInt(4, u.getId());
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

    private List<Usuario> bucarNoBD(String sql) {
        List<Usuario> usuarios = new ArrayList<>();
        try {

            pst = conn.getConnection().prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                usuarios.add(montarUsuario(rs));

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
        return usuarios;
    }

    private Usuario montarUsuario(ResultSet rs) throws SQLException {
        Usuario u = new Usuario();
        u.setId(rs.getInt("id"));
        u.setNome(rs.getString("nome"));
        u.setEmail(rs.getString("email"));
        u.setSenha(rs.getString("senha"));
        return u;
    }
}
