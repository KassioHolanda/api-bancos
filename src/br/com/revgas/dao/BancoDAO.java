package br.com.revgas.dao;

import java.util.ArrayList;
import java.util.List;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import br.com.revgas.config.BDConfig;
import br.com.revgas.model.Banco;
import br.com.revgas.utils.Constantes;

public class BancoDAO {

	public Connection openConnection() throws Exception {
		return BDConfig.getConnection();
	}

	public List<Banco> recuperarBancos() throws Exception {
		List<Banco> bancos = new ArrayList<>();
		String sql = "SELECT * FROM BANCO";

		Connection conexao = openConnection();

		PreparedStatement statement = conexao.prepareStatement(sql);
		ResultSet resultado = statement.executeQuery();

		while (resultado.next()) {

			bancos.add(new Banco(resultado.getLong(Constantes.ID_TABLE),
					resultado.getInt(Constantes.CODIGO_COMPENSACAO), resultado.getString(Constantes.NOME_INSTITUICAO)));
		}

		return bancos;
	}

	public Banco recuperarPorId(long bancoId) throws Exception {
		String sql = "SELECT * FROM BANCO WHERE " + Constantes.ID_TABLE + " = ?";

		Connection conexao = openConnection();

		PreparedStatement statement = conexao.prepareStatement(sql);
		statement.setLong(1, bancoId);
		ResultSet resultado = statement.executeQuery();
		
		if (resultado.next()) {
			return new Banco(resultado.getLong(Constantes.ID_TABLE), resultado.getInt(Constantes.CODIGO_COMPENSACAO),
					resultado.getString(Constantes.NOME_INSTITUICAO));
		}
		return null;
	}

	public Banco recuperarPorCodigoCompensacao(int codigo) throws Exception {
		
		String sql = "SELECT * FROM BANCO WHERE " + Constantes.CODIGO_COMPENSACAO + " = ?";

		Connection conexao = openConnection();

		PreparedStatement statement = conexao.prepareStatement(sql);
		statement.setInt(1, codigo);
		ResultSet resultado = statement.executeQuery();

		if (resultado.next()) {
			return new Banco(resultado.getLong(Constantes.ID_TABLE), resultado.getInt(Constantes.CODIGO_COMPENSACAO),
					resultado.getString(Constantes.NOME_INSTITUICAO));
		}
		return null;
	}

	public void adicionarBanco(Banco banco) throws Exception {
		
		String sql = "INSERT INTO BANCO(" + Constantes.CODIGO_COMPENSACAO + ", " + Constantes.NOME_INSTITUICAO
				+ ") VALUES (?, ?)";

		Connection conexao = openConnection();

		PreparedStatement statement = conexao.prepareStatement(sql);
		statement.setInt(1, banco.getCodigoDeCompensacao());
		statement.setString(2, banco.getNomeInstituicao());
		statement.execute();
	}

	public void atualizarBanco(Banco banco, long idBanco) throws Exception {
		String sql = "UPDATE BANCO SET " + Constantes.CODIGO_COMPENSACAO + " = ?, " + Constantes.NOME_INSTITUICAO
				+ " = ? WHERE ID = ?";

		Connection conexao = openConnection();

		PreparedStatement statement = conexao.prepareStatement(sql);
		statement.setInt(1, banco.getCodigoDeCompensacao());
		statement.setString(2, banco.getNomeInstituicao());
		statement.setLong(3, banco.getId());
		statement.execute();
	}

	public void removerBanco(long bancoId) throws Exception {
		String sql = "DELETE FROM BANCO WHERE " + Constantes.ID_TABLE + " = ?";

		Connection conexao = openConnection();

		PreparedStatement statement = conexao.prepareStatement(sql);
		statement.setLong(1, bancoId);
		statement.execute();
	}
}
