package br.com.aplicacao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AppConsultaFuncionarios {

	public static void main(String[] args) {
		
		try {
			
            String conexao = "jdbc:mysql://localhost:3306/db_cadastro?autoSSL=false";			
			Class.forName("com.mysql.cj.jdbc.Driver");			
			Connection cn =  DriverManager.getConnection(conexao,"root","Timao00858..");
			
			String sql = "SELECT * FROM TBFUNCIONARIOS";
			
			PreparedStatement stmt = cn.prepareStatement(sql);
			
			ResultSet rs = stmt.executeQuery();
			
			//listando os registros.
			
			while(rs.next()) {
								
				System.out.println("Documento: " + rs.getString("DOCUMENTO"));				
				System.out.println("Nome: " + rs.getString("NOME"));
				System.out.println("Idade: " + rs.getInt("IDADE"));
				System.out.println("Sexo: " + rs.getString("SEXO"));
				System.out.println("Cargo: " + rs.getString("CARGO"));
				System.out.println("Sálario: " + rs.getDouble("SALARIO"));
				System.out.println();				
			}
			
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
