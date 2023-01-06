package br.com.dal;
import java.util.Collection;

import br.com.enumeracoes.*;
import br.com.classes.Funcionario;

public class FuncionariosDAO {

	public class FuncionariosDao extends Dao<Funcionario, String> {

		@Override
		public void incluir(Funcionario item) throws Exception {
			
			try {
				 abrirConexao();
				 
				//incluindo um novo funcionário
					String sql = "INSERT INTO TBFUNCIONARIOS(DOCUMENTO, NOME, IDADE,"
							+ "SEXO,CARGO,SALARIO) VALUES(?,?,?,?,?,?)";
					
					stmt = cn.prepareStatement(sql);
					stmt.setString(1,item.getDocumento().getNumero());
					stmt.setString(2,item.getNome());
					stmt.setInt(3, item.getIdade());
					stmt.setString(4, item.getSexo() == Sexo.MASCULINO ? "M": "F");
					stmt.setString(5,item.getCargo());
					stmt.setDouble(6,item.getSalario());
					
					stmt.executeUpdate();
					
				
			} catch (Exception e) {
				
				throw e;
				
			} finally {
				
				fecharConexao();			
			}
			
			
			
		}

		@Override
		public void buscar(String id) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public Collection<Funcionario> listar() {
			// TODO Auto-generated method stub
			return null;
		}

	}

	public void incluir(Funcionario funcionario) {
		// TODO Auto-generated method stub
		
	}

}
