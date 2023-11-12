package br.com.fiap.megatech.model.entity;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.PositiveOrZero;

public class Bike {
	private Long idBike;
	@NotBlank
	private Long idCliente;
	@NotBlank
	private String nomeMarca;
	@NotBlank
	private String tipoModelo;
	@NotBlank
	@PastOrPresent
	private LocalDate dataCompra;
	@NotBlank
	@PastOrPresent
	private LocalDate dataFabricacao;
	@NotBlank
	private String funcaoBike;
	@NotBlank
	private String cor;
	@NotBlank
	@PositiveOrZero
	private double valorMercado;
	@NotBlank
	private Long numeroChassi;
	
	public Bike() {
	}

	public Bike(Long idBike, @NotBlank Long idCliente, @NotBlank String nomeMarca, @NotBlank String tipoModelo,
			@NotBlank @PastOrPresent LocalDate dataCompra, @NotBlank @PastOrPresent LocalDate dataFabricacao,
			@NotBlank String funcaoBike, @NotBlank String cor, @NotBlank @PositiveOrZero double valorMercado,
			@NotBlank Long numeroChassi) {
		this.idBike = idBike;
		this.idCliente = idCliente;
		this.nomeMarca = nomeMarca;
		this.tipoModelo = tipoModelo;
		this.dataCompra = dataCompra;
		this.dataFabricacao = dataFabricacao;
		this.funcaoBike = funcaoBike;
		this.cor = cor;
		this.valorMercado = valorMercado;
		this.numeroChassi = numeroChassi;
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

	public String getNomeMarca() {
		return nomeMarca;
	}

	public void setNomeMarca(String nomeMarca) {
		this.nomeMarca = nomeMarca;
	}

	public String getTipoModelo() {
		return tipoModelo;
	}

	public void setTipoModelo(String tipoModelo) {
		this.tipoModelo = tipoModelo;
	}

	public LocalDate getDataCompra() {
		return dataCompra;
	}

	public void setDataCompra(LocalDate dataCompra) {
		this.dataCompra = dataCompra;
	}

	public LocalDate getDataFabricacao() {
		return dataFabricacao;
	}

	public void setDataFabricacao(LocalDate dataFabricacao) {
		this.dataFabricacao = dataFabricacao;
	}

	public String getFuncaoBike() {
		return funcaoBike;
	}

	public void setFuncaoBike(String funcaoBike) {
		this.funcaoBike = funcaoBike;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public double getValorMercado() {
		return valorMercado;
	}

	public void setValorMercado(double valorMercado) {
		this.valorMercado = valorMercado;
	}

	public Long getNumeroChassi() {
		return numeroChassi;
	}

	public void setNumeroChassi(Long numeroChassi) {
		this.numeroChassi = numeroChassi;
	}
	
	
}
