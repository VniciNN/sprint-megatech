package br.com.fiap.megatech.model.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.fiap.megatech.model.entity.ModificacaoBike;

public class ModificacaoBikeRepository extends Repository{
	
	public static ArrayList<ModificacaoBike> findAll() {
		ArrayList<ModificacaoBike> modsBike = new ArrayList<ModificacaoBike>();
		String sql = "select * from t_mgt_modificacao_bike";
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs != null) {
				while(rs.next()) {
					ModificacaoBike modificacaoBike = new ModificacaoBike();
					modificacaoBike.setIdComponente(rs.getLong("id_componente"));
					modificacaoBike.setNomeComponente(rs.getString("nm_componente"));
					modificacaoBike.setIdBike(rs.getLong("id_bike"));
					modificacaoBike.setIdCliente(rs.getLong("id_cliente"));
					modsBike.add(modificacaoBike);
				}
			} else {
				return null;
			}
		} catch (SQLException e) {
			System.out.println("Erro ao listar: " + e.getMessage());
		} finally {
			closeConnection();
		}
		return modsBike;
	}
	
	public static ModificacaoBike save(ModificacaoBike modificacaoBike) {
		String sql = "insert into t_mgt_modificacao_bike "
				+ "(id_componente, nm_componente, id_bike, id_cliente) "
				+ "values(sq_id_componente.nextval, ?, ?, ?)";
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, modificacaoBike.getNomeComponente());
			ps.setLong(2, modificacaoBike.getIdCliente());
			ps.setLong(3, modificacaoBike.getIdBike());
			if(ps.executeUpdate() > 0) {
				return modificacaoBike;
			} else {
				return null;
			}
		} catch (SQLException e) {
			System.out.println("Erro ao salvar: " + e.getMessage());
		} finally {
			closeConnection();
		}
		return null;
	}
	
	public static ModificacaoBike update(ModificacaoBike modificacaoBike) {
		String sql = "Update t_mgt_modificacao_bike "
				+ "Set nm_componente=?, id_bike=?, id_cliente "
				+ "WHERE id_componente=?";
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, modificacaoBike.getNomeComponente());
			ps.setLong(2, modificacaoBike.getIdCliente());
			ps.setLong(3, modificacaoBike.getIdBike());
			ps.setLong(4, modificacaoBike.getIdComponente());
			if(ps.executeUpdate() > 0) {
				return modificacaoBike;
			} else {
				return null;
			}
		} catch (SQLException e) {
			System.out.println("Erro ao salvar: " + e.getMessage());
		} finally {
			closeConnection();
		}
		return null;
	}
	
	public static boolean delete(Long id) {
		String sql = "delete from t_mgt_modificacao_bike where id_componente = ?";
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setLong(1, id);
			if(ps.executeUpdate() > 0) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			System.out.println("Erro ao salvar: " + e.getMessage());
		} finally {
			closeConnection();
		}
		return false;
	}
}
