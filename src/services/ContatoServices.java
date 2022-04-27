package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Contato;
import persistence.ConnectionFactory;

public class ContatoServices {

	public ContatoServices() {
		super();
	}
	
	public void addContato(Contato ctt) {
		Connection conn = ConnectionFactory.getConnection();
		
		try {
			String sql = "INSERT INTO tbl_contatos (nome, telefone, celular, email) VALUES (?,?,?,?);";
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, ctt.getNome());
			stmt.setString(2, ctt.getTelefone());
			stmt.setString(3, ctt.getCelular());
			stmt.setString(4, ctt.getEmail());
			stmt.execute();
			
			conn.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
	
	public void updateContato(Contato ctt) {
		Connection conn = ConnectionFactory.getConnection();
		
		try{
			String sql = "UPDATE tbl_contatos SET nome = ?, telefone = ?, celular = ?, email = ? WHERE id = ?;";
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, ctt.getNome());
			stmt.setString(2, ctt.getTelefone());
			stmt.setString(3, ctt.getCelular());
			stmt.setString(4, ctt.getEmail());
			stmt.setInt(5, ctt.getId());
			stmt.execute();
			stmt.close();
			
			
			
			conn.close();
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void deleteContato(int pid) {
		Connection conn = ConnectionFactory.getConnection();
		
		try {
			String sql = "DELETE FROM tbl_contatos WHERE id = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, pid);
			stmt.execute();
			
			conn.close();
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}
	
	public List<Contato> getAll(){
		Connection conn = ConnectionFactory.getConnection();
		
		List<Contato> lista = new ArrayList<Contato>();
		
		try {
			String sql = "SELECT * FROM tbl_contatos;";
			Statement stmt = conn.createStatement();
			ResultSet r = stmt.executeQuery(sql);
			while(r.next()) {
				lista.add(new Contato(r.getInt(1), r.getString(2), r.getString(3), r.getString(4), r.getString(5)));
			}
			conn.close();
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return lista;
	}
	
	public List<Contato> procurarContatoNome(String pnome){
		Connection conn = ConnectionFactory.getConnection();
		
		List<Contato> lista = new ArrayList<Contato>();
		
		try {
			String sql = "SELECT * FROM tbl_contatos WHERE nome like ?;";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1,"%" + pnome + "%");
			ResultSet r = stmt.executeQuery();
			while(r.next()) {
				lista.add(new Contato(r.getInt(1), r.getString(2), r.getString(3), r.getString(4), r.getString(5)));
			}
			conn.close();
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return lista;
	}
	
	public List<Contato> procurarContatoId(int pid){
		Connection conn = ConnectionFactory.getConnection();
		
		List<Contato> lista = new ArrayList<Contato>();
		
		try {
			String sql = "SELECT * FROM tbl_contatos WHERE id = ?;";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, pid);
			ResultSet r = stmt.executeQuery();
			while(r.next()) {
				lista.add(new Contato(r.getInt(1), r.getString(2), r.getString(3), r.getString(4), r.getString(5)));
			}
			conn.close();
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return lista;
	}
	
}
