package br.com.fiap.megatech.model.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.fiap.megatech.model.entity.Cliente;

public class ClienteRepository extends Repository{

	public static ArrayList<Cliente> findAll() {
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		String sql = "select * from t_mgt_cliente";
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs != null) {
				while(rs.next()) {
					Cliente cliente = new Cliente();
					cliente.setIdCliente(rs.getLong("id_cliente"));
					cliente.setNomeCLiente(rs.getString("nm_cliente"));
					cliente.setCpf(rs.getString("nr_cpf"));
					clientes.add(cliente);
				}
			} else {
				return null;
			}
		} catch (SQLException e) {
			System.out.println("Erro ao listar: " + e.getMessage());
		} finally {
			closeConnection();
		}
		return clientes;
	}
	
	public static Cliente save(Cliente cliente) {
		String sql = "insert into t_mgt_cliente "
				+ "(id_cliente, nm_cliente, nr_cpf) "
				+ "values(sq_id_cliente.nextval, ?, ?)";
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, cliente.getNomeCLiente());
			ps.setString(2, cliente.getCpf());
			if(ps.executeUpdate() > 0) {
				return cliente;
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
	
	public static Cliente update(Cliente cliente) {
		String sql = "Update t_mgt_cliente "
				+ "Set nm_cliente=?, nr_cpf=? "
				+ "WHERE id_cliente=?";
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, cliente.getNomeCLiente());
			ps.setString(2, cliente.getCpf());
			ps.setLong(3, cliente.getIdCliente());
			if(ps.executeUpdate() > 0) {
				return cliente;
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
		String sql = "delete from t_mgt_cliente where id_cliente = ?";
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
