package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import model.Usuario;

public class UsuarioDAO {
	
	private static final String DB_DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static final String DB_CONNECTION = "jdbc:oracle:thin:@localhost:1521:MKYONG";
	private static final String DB_USER = "user";
	private static final String DB_PASSWORD = "password";
	
	public Usuario buscaUsuario(String email){
		Connection conn = null;
		PreparedStatement prepStatement = null;
		Usuario usuario = null;
		
		String sql = "SELECT nome, email, senha FROM usuario WHERE email = ?";
		
		try{
			conn = this.getConnection();
			prepStatement = conn.prepareStatement(sql);
			
			prepStatement.setString(1, email);
			ResultSet result = prepStatement.getResultSet();
			while(result.next()){
				String nome = result.getString("nome");
				String email1 = result.getString("email");
				String senha = result.getString("senha");
				usuario = new Usuario(nome,email1,senha);
			}
			return usuario;
		}
		catch(Exception e){
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	public void insertUsuario(Usuario user){
		Connection conn = null;
		PreparedStatement prepStatement = null;
		
		String sql = "INSERT INTO usuario VALUES (?,?,?)";
		
		try{
			conn = this.getConnection();
			prepStatement = conn.prepareStatement(sql);
			
			prepStatement.setString(1, user.getNome());
			prepStatement.setString(2, user.getEmail());
			prepStatement.setString(3, user.getSenha());
			prepStatement.executeUpdate();
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	public void deleteUsuario(Usuario user){
		Connection conn = null;
		PreparedStatement prepStatement = null;
		
		String sql = "DELETE FROM usuario WHERE email = ?";
		
		try{
			conn = this.getConnection();
			prepStatement = conn.prepareStatement(sql);
			
			prepStatement.setString(1, user.getEmail());
			prepStatement.executeUpdate();
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	public void updateUsuario(Usuario user){
		Connection conn = null;
		PreparedStatement prepStatement = null;
		
		String sql = "UPDATE usuario SET nome = ?, senha = ? WHERE email = ?";
		
		try{
			conn = this.getConnection();
			prepStatement = conn.prepareStatement(sql);
			
			prepStatement.setString(1, user.getNome());
			prepStatement.setString(2, user.getSenha());
			prepStatement.setString(3, user.getEmail());
			prepStatement.executeUpdate();
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	
	public Connection getConnection(){
		String url = "jdbc:postgresql://localhost/test";
		Properties props = new Properties();
		props.setProperty("user","fidel");
		props.setProperty("password","123456");
		props.setProperty("ssl","true");
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, props);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		 return conn;

	}

}
