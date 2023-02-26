package com.stefanini.service;

import com.stefanini.dto.StefamonDTO;
import com.stefanini.exceptions.RegraDeNegocioException;
import com.stefanini.parser.StefamonParser;
import com.stefanini.repository.StefamonRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@ApplicationScoped
public class StefamonService {

    @Inject
    StefamonRepository repository;

    public List<StefamonDTO> listarTodos(){
        return repository.listAll().stream().map(s -> StefamonParser.EntitytoDto(s)).collect(Collectors.toList());
    }

    public StefamonDTO pegarPorId(Long id) {
        var stefamon =  repository.findById(id);
        if(Objects.isNull(stefamon)) {
            throw new RegraDeNegocioException("Não encontramos nada com o id " + id, Response.Status.NOT_FOUND);
        }
        return StefamonParser.EntitytoDto(stefamon);
    }

 }
