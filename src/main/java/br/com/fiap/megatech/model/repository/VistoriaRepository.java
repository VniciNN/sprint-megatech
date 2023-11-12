package br.com.fiap.megatech.model.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.fiap.megatech.model.entity.Vistoria;

public class VistoriaRepository extends Repository{
	
	public static ArrayList<Vistoria> findAll() {
		ArrayList<Vistoria> vistorias = new ArrayList<Vistoria>();
		String sql = "select * from t_mgt_vistoria";
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs != null) {
				while(rs.next()) {
					Vistoria vistoria = new Vistoria();
					vistoria.setIdVistoria(rs.getLong("id_vistoria"));
					vistoria.setIdBike(rs.getLong("id_bike"));
					vistoria.setIdCliente(rs.getLong("id_cliente"));
					vistoria.setFotoBike(rs.getString("ft_bike"));
					vistoria.setFotoNotaFiscal(rs.getString("ft_nota_fiscal"));
					vistoria.setVideoBike(rs.getString("vd_bike"));
					vistoria.setModelo(rs.getString("modelo"));
					vistorias.add(vistoria);
				}
			} else {
				return null;
			}
		} catch (SQLException e) {
			System.out.println("Erro ao listar: " + e.getMessage());
		} finally {
			closeConnection();
		}
		return vistorias;
	}
	
	public static Vistoria save(Vistoria vistoria) {
		String sql = "insert into t_mgt_vistoria "
				+ "(id_vistoria, id_bike, id_cliente, ft_bike, ft_nota_fiscal, vd_bike, modelo) "
				+ "values(sq_id_cliente.nextval, ?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setLong(1, vistoria.getIdVistoria());
			ps.setLong(2, vistoria.getIdBike());
			ps.setLong(3, vistoria.getIdCliente());
			ps.setString(4, vistoria.getFotoBike());
			ps.setString(5, vistoria.getFotoNotaFiscal());
			ps.setString(6, vistoria.getVideoBike());
			ps.setString(7, vistoria.getModelo());
			if(ps.executeUpdate() > 0) {
				return vistoria;
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
	
	public static Vistoria update(Vistoria vistoria) {
		String sql = "Update t_mgt_vistoria "
				+ "Set id_bike=?, id_cliente=?, ft_bike=?, ft_nota_fiscal=?, vd_bike=?, modelo=? "
				+ "WHERE id_vistoria=?";
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setLong(1, vistoria.getIdBike());
			ps.setLong(2, vistoria.getIdCliente());
			ps.setString(3, vistoria.getFotoBike());
			ps.setString(4, vistoria.getFotoNotaFiscal());
			ps.setString(5, vistoria.getVideoBike());
			ps.setString(6, vistoria.getModelo());
			ps.setLong(7, vistoria.getIdVistoria());
			if(ps.executeUpdate() > 0) {
				return vistoria;
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
		String sql = "delete from t_mgt_vistoria where id_vistoria = ?";
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
