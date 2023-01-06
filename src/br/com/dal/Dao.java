package br.com.dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Collection;

public abstract class Dao<T,K> {
	
	String conexao = "jdbc:mysql://localhost:3306/db_cadastro?autoSSL=false";
	
	//protected = acessivel para a classe e subclasses.
	protected Connection cn;
	protected PreparedStatement stmt;
	protected ResultSet rs;
	
	
	//metodo para abrir a conexao
	protected void abrirConexao() throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Drive");		
		cn =  DriverManager.getConnection(conexao,"root","Timao00858..");		
		
	}
	
	
	//metodo para fechar a conexao
	protected void fecharConexao()  throws Exception {
		
		if(cn != null &&  !cn.isClosed()) {			
			cn.close();			
		}	
		
	}
	
	
	public abstract void incluir(T item) throws Exception;
	public abstract void buscar(K id) throws Exception;
	public abstract Collection<T> listar() throws Exception;
}
	
