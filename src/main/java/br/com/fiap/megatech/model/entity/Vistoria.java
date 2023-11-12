package br.com.fiap.megatech.model.entity;

public class Vistoria {
	private Long idVistoria;
	private Long idBike;
	private Long idCliente;
	private String fotoBike;
	private String fotoNotaFiscal;
	private String videoBike;
	private String modelo;
	
	public Vistoria() {

	}

	public Vistoria(Long idVistoria, Long idBike, Long idCliente, String fotoBike, String fotoNotaFiscal,
			String videoBike, String modelo) {
		this.idVistoria = idVistoria;
		this.idBike = idBike;
		this.idCliente = idCliente;
		this.fotoBike = fotoBike;
		this.fotoNotaFiscal = fotoNotaFiscal;
		this.videoBike = videoBike;
		this.modelo = modelo;
	}

	public Long getIdVistoria() {
		return idVistoria;
	}

	public void setIdVistoria(Long idVistoria) {
		this.idVistoria = idVistoria;
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

	public String getFotoBike() {
		return fotoBike;
	}

	public void setFotoBike(String fotoBike) {
		this.fotoBike = fotoBike;
	}

	public String getFotoNotaFiscal() {
		return fotoNotaFiscal;
	}

	public void setFotoNotaFiscal(String fotoNotaFiscal) {
		this.fotoNotaFiscal = fotoNotaFiscal;
	}

	public String getVideoBike() {
		return videoBike;
	}

	public void setVideoBike(String videoBike) {
		this.videoBike = videoBike;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
	
}
