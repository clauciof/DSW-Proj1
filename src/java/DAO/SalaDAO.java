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

import model.SalaTeatro;
import model.Site;


/**
 *
 * @author clauc
 */
public class SalaDAO {
    
    
    public SalaDAO() {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    protected Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:derby://localhost:1527/SistemaVendasDB", "root", "root");
    }

    public void insert(SalaTeatro salaTeatro) {
        //criar tabela no BD para Site
        ////String sql = "INSERT INTO Site (endereço email, senha, endereco, nome, telefone) VALUES (?, ?, ?, ?, ?)"
        String sql = "INSERT INTO salateatro (cnpj, email, senha, cidade, nome) VALUES (?, ?, ?, ?, ?)";
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement = conn.prepareStatement(sql);
            statement.setString(1, salaTeatro.getCnpj());
            statement.setString(2, salaTeatro.getEmail());
            statement.setString(3, salaTeatro.getSenha());
            statement.setString(4, salaTeatro.getCidade());
            statement.setString(5, salaTeatro.getNome());
            statement.executeUpdate();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
   
    public List<SalaTeatro> getAlmostAll() {
        List<SalaTeatro> listaSalateatro = new ArrayList<>();
        String sql = "SELECT email, cidade, nome, cnpj FROM salateatro";
        try {
            Connection conn = this.getConnection();
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                String email = resultSet.getString("email");
                String cidade = resultSet.getString("cidade");
                String nome = resultSet.getString("nome");
                String cnpj = resultSet.getString("cnpj");
                
                SalaTeatro salateatro = new SalaTeatro(email, cidade, nome, cnpj);
                listaSalateatro.add(salateatro);
            }
            
            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaSalateatro;
    }
    
      public void delete(SalaTeatro salaTeatro) {
        String sql = "DELETE FROM salateatro where cnpj = ?";
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, salaTeatro.getCnpj());
            statement.executeUpdate();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
      
      public void update(SalaTeatro salaTeatro) {
        
        String sql = "UPDATE salateatro SET cidade = ?, email = ?, senha = ?, nome = ?, cnpj = ?";
        sql += " WHERE cnpj = ?";
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, salaTeatro.getCidade());
            statement.setString(2, salaTeatro.getEmail());
            statement.setString(3, salaTeatro.getSenha());
            statement.setString(4, salaTeatro.getNome());
            statement.setString(5, salaTeatro.getCnpj());
            statement.setString(6, salaTeatro.getCnpj());
            statement.executeUpdate();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
      
      
    public SalaTeatro get(String cnpj) {
        SalaTeatro salateatro = null;
        String sql = "SELECT * FROM salateatro WHERE cnpj = ?";
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, cnpj);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String cnpj_ = resultSet.getString("cnpj");
                String email = resultSet.getString("email");
                String senha = resultSet.getString("senha");
                String cidade = resultSet.getString("cidade");
                String nome = resultSet.getString("nome");
                salateatro = new SalaTeatro(email, senha, cidade, nome, cnpj);
            }
            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return salateatro;
    }
    
    
    
    
    
    
}
