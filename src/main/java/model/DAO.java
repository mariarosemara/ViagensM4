package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DAO {

	private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/viagens";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "";
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	
	private Connection conectar() throws ClassNotFoundException {
		Connection con = null;	
		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(DATABASE_URL,USERNAME,PASSWORD);
			return con;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}		
	}
	
	public void inserirCliente(Cliente cliente) {

		String sql = "insert into cliente(nome,cpf,login,senha) values (?,?,?,?)";
		
		try {
			Connection con = conectar();
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setString(1,cliente.getNome());
			stm.setString(2,cliente.getCpf());
			stm.setString(3,cliente.getLogin());
			stm.setString(4, cliente.getSenha());

			stm.execute();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
    public ArrayList<Cliente>	listarClientes() {
    	ArrayList<Cliente> clientes = new ArrayList<>();
    	
    	String sql = "select * from cliente order by nome";
    	try {
    		Connection con = conectar();
    		PreparedStatement stm = con.prepareStatement(sql);
    		ResultSet result = stm.executeQuery();

    		while (result.next()) {
    			String id = result.getString(1);
    			String nome = result.getString(2);
    			String cpf = result.getString(3);
    			String login = result.getString(4);
    			String senha = result.getString(5);
    			clientes.add(new Cliente(id,nome,cpf,login,senha));
    		}

    		con.close();
    		return clientes;
    	} catch (Exception e) {
    		System.out.println(e);
    		return null;
    	}
    	
    }
    public void selecionarCliente(Cliente cliente) {
    	String sql = "select * from cliente where id = ?";
    	
    	try {
    		Connection con = conectar();
    		PreparedStatement stm = con.prepareStatement(sql);
    		stm.setString(1, cliente.getId());
    		ResultSet result = stm.executeQuery();

    		while (result.next()) {
    			cliente.setId(result.getString(1));
    			cliente.setNome(result.getString(2));
    			cliente.setCpf(result.getString(3));
    			cliente.setLogin(result.getString(4));
    			cliente.setSenha(result.getString(5));
    		}
    		con.close();
    	} catch (Exception e) {
    		System.out.println(e);
    	}
    }

    public void alterarCliente(Cliente cliente) {
    	String sql = "update cliente set nome=?,cpf=?,login=?,senha=? where id=?";
    	
    	try {
    		Connection con = conectar();
    		PreparedStatement stm = con.prepareStatement(sql);
    		stm.setString(1, cliente.getNome());
    		stm.setString(2, cliente.getCpf());
    		stm.setString(3, cliente.getLogin());
    		stm.setString(4, cliente.getSenha()); 
    		stm.setString(5, cliente.getId());
    		
    		stm.executeUpdate();
    		con.close();
    	} catch (Exception e) {
    		System.out.println(e);
    	}
    }
    
	public void deletarCliente(Cliente cliente) {
		String sql = "delete from cliente where id=?";		
		try {
			Connection con = conectar();
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setString(1, cliente.getId());
			stm.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	
}