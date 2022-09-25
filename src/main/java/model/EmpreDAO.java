package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmpreDAO {
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
	
	public void inserirEmpresa(Empresa empresa) {

		String sql = "insert into empresa(cnpj, localidade,proprietario,login,senha) values (?,?,?,?,?)";
		
		try {
			Connection con = conectar();
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setString(1,empresa.getCnpj());
			stm.setString(2,empresa.getLocalidade());
			stm.setString(3,empresa.getProprietario());
			stm.setString(4,empresa.getLogin());
			stm.setString(5, empresa.getSenha());

			stm.execute();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}

    public ArrayList<Empresa>	listarEmpresas() {

    	ArrayList<Empresa> empresas = new ArrayList<>();
    	
    	String sql = "select * from empresa order by cnpj";
    	try {
    		Connection con = conectar();
    		PreparedStatement stm = con.prepareStatement(sql);
    		ResultSet result = stm.executeQuery();
    		while (result.next()) {
    			String id = result.getString(1);
    			String cnpj = result.getString(2);
    			String localidade = result.getString(3);
    			String proprietario = result.getString(4);
    			String login = result.getString(5);
    			String senha = result.getString(6);
    			empresas.add(new Empresa(id,cnpj,localidade,proprietario,login,senha));
    		}
    		con.close();
    		return empresas;
    	} catch (Exception e) {
    		System.out.println(e);
    		return null;
    	}
    	
    }
    
    public void selecionarEmpresa(Empresa empresa) {
    	String sql = "select * from empresa where id = ?";
    	
    	try {
    		Connection con = conectar();
    		PreparedStatement stm = con.prepareStatement(sql);
    		stm.setString(1, empresa.getId());
    		ResultSet result = stm.executeQuery();
    		while (result.next()) {
    			empresa.setId(result.getString(1));
    			empresa.setCnpj(result.getString(2));
    			empresa.setLocalidade(result.getString(3));
    			empresa.setProprietario(result.getString(4));;
    			empresa.setLogin(result.getString(5));
    			empresa.setSenha(result.getString(6));
    		}
    		con.close();
    	} catch (Exception e) {
    		System.out.println(e);
    	}
    }

    public void alterarEmpresa(Empresa empresa) {
    	String sql = "update empresa set cnpj=?,localidade=?,proprietario=?,login=?,senha=? where id=?";
    	
    	try {
    		Connection con = conectar();
    		PreparedStatement stm = con.prepareStatement(sql);
    		stm.setString(1, empresa.getCnpj());
    		stm.setString(2, empresa.getLocalidade());
    		stm.setString(3, empresa.getProprietario());
    		stm.setString(4, empresa.getLogin());
    		stm.setString(5, empresa.getSenha()); 
    		stm.setString(6, empresa.getId());		
    		stm.executeUpdate();
    		con.close();
    	} catch (Exception e) {
    		System.out.println(e);
    	}
    }
    
	public void deletarEmpresa(Empresa empresa) {
		String sql = "delete from empresa where id=?";		
		try {
			Connection con = conectar();
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setString(1, empresa.getId());
			stm.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}

