package com.stefanini.resources;

import com.stefanini.dto.JogadorDTO;
import com.stefanini.dto.StefamonDTO;
import com.stefanini.entity.Jogador;
import com.stefanini.service.JogadorService;

import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/jogador")
public class JogadorResource {

    @Inject
    JogadorService jogadorService;

    @GET
    @Path("/{id}")
    public Response pegarPorId(@PathParam("id") Long id){
        return Response.status(Response.Status.OK).entity(jogadorService.pegarPorId(id)).build();
    }

    @GET
    @Path("/todos")
    public Response listarTodos(){
        return Response.status(Response.Status.OK).entity(jogadorService.listarTodos()).build();
    }

    @POST
    public Response salvar(@Valid JogadorDTO jogadorDTO) {
        jogadorService.salvar(jogadorDTO);
        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    public Response alterar(@Valid Jogador jogador) {
        jogadorService.alterar(jogador);
        return Response.status(Response.Status.OK).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deletar(@PathParam("id") Long id) {
        jogadorService.deletar(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }

    @POST
    @Path("/login")
    @Produces(MediaType.TEXT_PLAIN)
    public Response login(@Valid JogadorDTO jogador) {
        return Response.status(Response.Status.OK).entity(jogadorService.logar(jogador)).build();
    }

    @PUT
    @Path("/comprarStefamons/{id}")
    public Response login(@PathParam("id") Long id,List<@Valid StefamonDTO> stefamons){
        jogadorService.comprarStefamons(stefamons, id);
        return Response.status(Response.Status.OK).build();

    }

}
