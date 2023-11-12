package br.com.fiap.megatech.model.entity;

import jakarta.validation.constraints.NotBlank;

public class Cliente {
	
	private Long idCliente;
	@NotBlank
	private String nomeCLiente;
	@NotBlank
	private String cpf;
	
	
	public Cliente() {
		
	}

	public Cliente(Long idCliente, @NotBlank String nomeCLiente, @NotBlank String cpf) {
		this.idCliente = idCliente;
		this.nomeCLiente = nomeCLiente;
		this.cpf = cpf;
	}

	public Long getIdCliente() {
		return idCliente;
	}


	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}


	public String getNomeCLiente() {
		return nomeCLiente;
	}


	public void setNomeCLiente(String nomeCLiente) {
		this.nomeCLiente = nomeCLiente;
	}


	public String getCpf() {
		return cpf;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	
	
}
