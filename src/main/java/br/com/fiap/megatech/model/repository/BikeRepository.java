package br.com.fiap.megatech.model.repository;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.fiap.megatech.model.entity.Bike;

public class BikeRepository extends Repository{

	public static ArrayList<Bike> findAll() {
		ArrayList<Bike> bikes = new ArrayList<Bike>();
		String sql = "select * from t_mgt_bike";
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs != null) {
				while(rs.next()) {
					Bike bike = new Bike();
					bike.setIdBike(rs.getLong("id_bike"));
					bike.setIdCliente(rs.getLong("id_cliente"));
					bike.setNomeMarca(rs.getString("nm_marca"));
					bike.setTipoModelo(rs.getString("tp_modelo"));
					bike.setDataCompra(rs.getDate("dt_compra").toLocalDate());
					bike.setDataFabricacao(rs.getDate("ds_ano_bike").toLocalDate());
					bike.setFuncaoBike(rs.getString("funcao_bike"));
					bike.setCor(rs.getString("cor"));
					bike.setValorMercado(rs.getDouble("vl_mercado"));
					bike.setNumeroChassi(rs.getLong("nr_chassi"));
					bikes.add(bike);
				}
			} else {
				return null;
			}
		} catch (SQLException e) {
			System.out.println("Erro ao listar: " + e.getMessage());
		} finally {
			closeConnection();
		}
		return bikes;
	}
	
	public static Bike save(Bike bike) {
		String sql = "insert into t_mgt_bike "
				+ "(id_bike, id_cliente, nm_marca, tp_modelo, dt_compra, ds_ano_bike, funcao_bike, cor, vl_mercado, nr_chassi)"
				+ " values(sq_id_bike.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setLong(1, bike.getIdCliente());
			ps.setString(2, bike.getNomeMarca());
			ps.setString(3, bike.getTipoModelo());
			ps.setDate(4, Date.valueOf(bike.getDataCompra()));
			ps.setDate(5, Date.valueOf(bike.getDataFabricacao()));
			ps.setString(6, bike.getFuncaoBike());
			ps.setString(7, bike.getCor());
			ps.setDouble(8, bike.getValorMercado());
			ps.setLong(9, bike.getNumeroChassi());
			if(ps.executeUpdate() > 0) {
				return bike;
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
	
	public static Bike update(Bike bike) {
		String sql = "Update t_mgt_bike "
				+ "Set id_cliente=?, nm_marca=?, tp_modelo=?, dt_compra=?, ds_ano_bike=?, funcao_bike=?, cor=?, vl_mercado=?, nr_chassi=?"
				+ "WHERE id_bike=?";
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setLong(1, bike.getIdCliente());
			ps.setString(2, bike.getNomeMarca());
			ps.setString(3, bike.getTipoModelo());
			ps.setDate(4, Date.valueOf(bike.getDataCompra()));
			ps.setDate(5, Date.valueOf(bike.getDataFabricacao()));
			ps.setString(6, bike.getFuncaoBike());
			ps.setString(7, bike.getCor());
			ps.setDouble(8, bike.getValorMercado());
			ps.setLong(9, bike.getNumeroChassi());
			ps.setLong(10, bike.getIdBike());
			if(ps.executeUpdate() > 0) {
				return bike;
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
		String sql = "delete from t_mgt_bike where id_bike = ?";
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
