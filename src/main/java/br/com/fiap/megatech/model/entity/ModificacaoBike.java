package br.com.fiap.megatech.model.entity;

import jakarta.validation.constraints.NotBlank;

public class ModificacaoBike {

	private Long idComponente;
	@NotBlank
	private String nomeComponente;
	@NotBlank
	private Long idBike;
	@NotBlank
	private Long idCliente;
	
	public ModificacaoBike() {
		
	}

	public ModificacaoBike(Long idComponente, @NotBlank String nomeComponente, @NotBlank String descricaoBike,
			@NotBlank Long idBike, @NotBlank Long idCliente) {
		this.idComponente = idComponente;
		this.nomeComponente = nomeComponente;
		this.idBike = idBike;
		this.idCliente = idCliente;
	}

	public Long getIdComponente() {
		return idComponente;
	}

	public void setIdComponente(Long idComponente) {
		this.idComponente = idComponente;
	}

	public String getNomeComponente() {
		return nomeComponente;
	}

	public void setNomeComponente(String nomeComponente) {
		this.nomeComponente = nomeComponente;
	}

	public Long getIdBike() {
		return idBike;
	}

	public void setIdBike(Long idBike) {
		this.idBike = idBike;
	}

	public Long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}
	
	
}
