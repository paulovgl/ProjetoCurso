package br.com.projeto.dao;

import br.com.projeto.jdbc.ConnectionFactory;
import br.com.projeto.model.Clientes;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClientesDAO {
    private Connection connection;

    public ClientesDAO() {
        this.connection = new ConnectionFactory().getConnection();
    }
    
    public void cadastrarCliente(Clientes cli){
        try {
            String sql = "INSERT INTO tb_clientes(nome,rg,cpf,email,telefone,celular,cep,endereco,numero,complemento,bairro,cidade,estado)" + " values(?,?,?,?,?,?,?,?,?,?,?,?) ";
            
            PreparedStatement stmt = connection.prepareStatement(sql);
            
            stmt.setString(1, cli.getNome());
            stmt.setString(2, cli.getRg());
            stmt.setString(3, cli.getCpf());
            stmt.setString(4, cli.getEmail());
            stmt.setString(5, cli.getTelefone());
            stmt.setString(6, cli.getCelular());
            stmt.setString(7, cli.getCep());
            stmt.setString(8, cli.getEndereco());
            stmt.setInt(9, cli.getNumero());
            stmt.setString(10, cli.getComplemento());
            stmt.setString(11, cli.getBairro());
            stmt.setString(12, cli.getCidade());
            stmt.setString(13, cli.getUf());
            
            stmt.execute();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(ClientesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    
    
}
