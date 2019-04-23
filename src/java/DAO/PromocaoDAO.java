/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Promocao;
import model.Site;

/**
 *
 * @author clauc
 */
public class PromocaoDAO {
      
    public PromocaoDAO() {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    protected Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:derby://localhost:1527/SistemaVendasDB", "root", "root");
    }

    public void insert(Promocao promocao) {
        //criar tabela no BD para Site
        ////String sql = "INSERT INTO Site (endereço email, senha, endereco, nome, telefone) VALUES (?, ?, ?, ?, ?)"
        String sql = "INSERT INTO promocao (cnpj, senha, url, peca, preco, data, horario) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement = conn.prepareStatement(sql);
              statement.setString(1, promocao.getCNPJ());
            statement.setString(2, promocao.getSenha());
            statement.setString(3, promocao.getUrl());
            statement.setString(4, promocao.getNome_peca());
            statement.setString(5, promocao.getPreco());
            statement.setString(6, promocao.getData_peca());
            statement.setString(7, promocao.getHorario());
            statement.executeUpdate();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

   /* public List<Promocao> getAll() {
        List<Promocao> listaPromocao = new ArrayList<>();
        String sql = "SELECT * FROM promocao";
        try {
            Connection conn = this.getConnection();
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                String email = resultSet.getString("email");
                String senha = resultSet.getString("senha");
                String endereco = resultSet.getString("endereco");
                String nome_peca = resultSet.getString("nome");
                String telefone = resultSet.getString("telefone");
                Site site = new Site(email, senha, endereco, nome_peca, telefone);
                listaPromocao.add(site);
            }
            
            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaPromocao;
    }*/
    
    
    public List<Promocao> getAlmostAll() {
        List<Promocao> listaPromocao = new ArrayList<>();
        String sql = "SELECT nome_peca, url, preco, data_peca, horario FROM promocao";
        try {
            Connection conn = this.getConnection();
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                String nome_peca = resultSet.getString("nome_peca");
                String url = resultSet.getString("url");
                String preco = resultSet.getString("preco");
                String data_peca = resultSet.getString("data_peca");
                String horario = resultSet.getString("horario");
                Promocao promocao = new Promocao(nome_peca, url, preco, data_peca, horario);
                listaPromocao.add(promocao);
            }
            
            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaPromocao;
    }
    
      public void delete(Promocao promocao) {
        String sql = "DELETE FROM promocao where url = ?";
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, promocao.getUrl());
            statement.executeUpdate();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
      
      public void update(Site site) {
        
        String sql = "UPDATE site SET endereco = ?, email = ?, senha = ?, nome = ?, telefone = ?";
        sql += " WHERE id = ?";
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, site.getEndereco());
            statement.setString(2, site.getEmail());
            statement.setString(3, site.getSenha());
            statement.setString(4, site.getNome());
            statement.setString(5, site.getTel());
            statement.executeUpdate();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
      
      
      public Site get(String endereco) {
        Site site = null;
        String sql = "SELECT * FROM Site WHERE endereco = ?";
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, endereco);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String email = resultSet.getString("email");
                String senha = resultSet.getString("senha");
                String nome = resultSet.getString("nome");
                String telefone = resultSet.getString("telefone");
                site = new Site(endereco, email, senha, nome, telefone);
            }
            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return site;
    }
}

