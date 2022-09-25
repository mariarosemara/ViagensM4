package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DestinoDAO {
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
	
	public void inserirDestino(Destino destino) {
		
		String sql = "insert into destino(nome, valor, localidade, proprietario) values (?,?,?,?)";
		
		try {
			Connection con = conectar();
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setString(1,destino.getNome());
			stm.setString(2,destino.getValor());
			stm.setString(3,destino.getLocalidade());
			stm.setString(4,destino.getProprietario());

			stm.execute();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
	
    public ArrayList<Destino>	listarDestinos() {
    	
    	ArrayList<Destino> destinos = new ArrayList<>();
    	
    	String sql = "select * from destino order by nome";
    	try {
    		Connection con = conectar();
    		PreparedStatement stm = con.prepareStatement(sql);
    		ResultSet result = stm.executeQuery();
    		while (result.next()) {
    			String id = result.getString(1);
    			String nome = result.getString(2);
    			String valor = result.getString(3);
    			String localidade = result.getString(4);
    			String proprietario = result.getString(5);
    			destinos.add(new Destino(id,nome,valor,localidade,proprietario));
    		}

    		con.close();
    		return destinos;
    	} catch (Exception e) {
    		System.out.println(e);
    		return null;
    	}
    	
    }
    
    public void selecionarDestino(Destino destino) {
    	String sql = "select * from destino where id = ?";
    	
    	try {
    		Connection con = conectar();
    		PreparedStatement stm = con.prepareStatement(sql);
    		stm.setString(1, destino.getId());
    		ResultSet result = stm.executeQuery();
    		while (result.next()) {
    			destino.setId(result.getString(1));
    			destino.setNome(result.getString(2));
    			destino.setValor(result.getString(3));
    			destino.setLocalidade(result.getString(4));
    			destino.setProprietario(result.getString(5));
    		}
    		con.close();
    	} catch (Exception e) {
    		System.out.println(e);
    	}
    }

    public void alterarDestino(Destino destino) {
    	String sql = "update destino set nome=?,valor=?,localidade=?,proprietario=? where id=?";
    	
    	try {
    		Connection con = conectar();
    		PreparedStatement stm = con.prepareStatement(sql);
    		stm.setString(1, destino.getNome());
    		stm.setString(2, destino.getValor());
    		stm.setString(3, destino.getLocalidade());
    		stm.setString(4, destino.getProprietario()); 
    		stm.setString(5, destino.getId());		
    		stm.executeUpdate();
    		con.close();
    	} catch (Exception e) {
    		System.out.println(e);
    	}
    }
    
	public void deletarDestino(Destino destino) {
		String sql = "delete from destino where id=?";		
		try {
			Connection con = conectar();
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setString(1, destino.getId());
			stm.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	
}