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
import model.Site;

/**
 *
 * @author clauc
 */

public class SiteDAO {

    public SiteDAO() {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    protected Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:derby://localhost:1527/SistemaVendasDB", "root", "root");
    }

    public void insert(Site site) {
        //criar tabela no BD para Site
        ////String sql = "INSERT INTO Site (endereço email, senha, endereco, nome, telefone) VALUES (?, ?, ?, ?, ?)"
        String sql = "INSERT INTO Livro (titulo, autor, ano, preco) VALUES (?, ?, ?, ?)";
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
           // statement = conn.prepareStatement(sql);
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

    public List<Site> getAll() {
        List<Site> listaLivros = new ArrayList<>();
        String sql = "SELECT * FROM Livro";
        try {
            Connection conn = this.getConnection();
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                String email = resultSet.getString("email");
                String senha = resultSet.getString("senha");
                String endereco = resultSet.getString("endereco");
                String nome = resultSet.getString("nome");
                String telefone = resultSet.getString("telefone");
                Site site = new Site(email, senha, endereco, nome, telefone);
                listaLivros.add(site);
            }
            
            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaLivros;
    }
    
      public void delete(Site site) {
        String sql = "DELETE FROM Livro where enedereco = ?";
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, site.getEndereco());
            statement.executeUpdate();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
      
      public void update(Site site) {
        
        String sql = "UPDATE Site SET enderecp = ?, email = ?, senha = ?, nome = ?, telefone = ?";
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
