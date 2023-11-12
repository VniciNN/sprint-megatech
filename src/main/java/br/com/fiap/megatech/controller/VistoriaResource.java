package br.com.fiap.megatech.controller;

import java.util.ArrayList;

import br.com.fiap.megatech.model.entity.Vistoria;
import br.com.fiap.megatech.model.repository.ModificacaoBikeRepository;
import br.com.fiap.megatech.model.repository.VistoriaRepository;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.ResponseBuilder;

@Path("/megatech/vistoria")
public class VistoriaResource {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response findAll() {
		ArrayList<Vistoria> resposta = VistoriaRepository.findAll();
		ResponseBuilder response = Response.ok();
		response.entity(resposta);
		return response.build();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response save(@Valid Vistoria vistoria) {
		Vistoria resposta = VistoriaRepository.save(vistoria);
		ResponseBuilder response = null;
		if (resposta != null) {
			response = Response.created(null); // 201 - Created
		} else {
			response = Response.status(400); // 400 - Bad Request
		}
		response.entity(resposta);
		return response.build();
	}
	
	@DELETE
	@Path("/{id}")
	public Response delete(@PathParam("id") Long id) {
		if (ModificacaoBikeRepository.delete(id)) {
			ResponseBuilder response = Response.noContent();
			return response.build();
		} else {
			ResponseBuilder response = Response.status(404);
			return response.build();
		}
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Response update(@Valid Vistoria vistoria) {
		Vistoria resposta = VistoriaRepository.update(vistoria);
		ResponseBuilder response = null;
		if (resposta != null) {
			response = Response.created(null);
		} else {
			response = Response.status(400);
		}
		response.entity(resposta);
		return response.build();
	}
	
}
