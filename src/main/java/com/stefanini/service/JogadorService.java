package com.stefanini.service;

import com.stefanini.dto.JogadorDTO;
import com.stefanini.dto.StefamonDTO;
import com.stefanini.entity.Jogador;
import com.stefanini.exceptions.RegraDeNegocioException;
import com.stefanini.parser.JogadorParser;
import com.stefanini.parser.StefamonParser;
import com.stefanini.repository.JogadorRepository;
import com.stefanini.util.Base64Util;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.NoResultException;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@ApplicationScoped
public class JogadorService {

    @Inject
    JogadorRepository jogadorRepository;

    public void salvar(JogadorDTO jogadorDTO) {
        if(temJogadorComNickName(jogadorDTO.nickname)){
            throw new RegraDeNegocioException("Jogador com esse nickname já existe", Response.Status.BAD_REQUEST);
        }
        Jogador jogador = JogadorParser.JogadorDtotoEntity(jogadorDTO);
        jogador.setSenha(Base64Util.encode(jogador.getSenha()));
        jogadorRepository.save(jogador);
    }

    public Jogador pegarPorId(Long id) {
        var jogador = jogadorRepository.findById(id);
        if(Objects.isNull(jogador)) {
            throw new RegraDeNegocioException("Ocorreu um erro ao buscar o Jogador de id " + id, Response.Status.NOT_FOUND);
        }
        return jogador;
    }

    private boolean temJogadorComNickName(String nickname) {
        try
        {
            Jogador jogador = jogadorRepository.findByNickName(nickname);
            return Objects.nonNull(jogador);
        }catch(NoResultException ex){
            return false;
        }
        
    }

    private boolean podeLogar(String nickname,String senha){
        try{
            Jogador jogador = jogadorRepository.findByNickNameAndSenha(nickname,senha);
            return Objects.nonNull(jogador);
        }catch(NoResultException ex){
            return false;
        }
    }

    public void alterar(Jogador jogador) {
        jogadorRepository.update(jogador);
    }

    public void deletar(Long id) {
        jogadorRepository.delete(id);
    }

    public List<Jogador> listarTodos() {
        return jogadorRepository.listAll();
    }

    public boolean logar(JogadorDTO jogadorDTO){
        if(podeLogar(jogadorDTO.nickname, jogadorDTO.senha)){
            return true;
        }else{
            throw new RegraDeNegocioException("Os dados de login estão incorretos", Response.Status.UNAUTHORIZED);
        }
         
    }

    public void comprarStefamons(List<StefamonDTO> stefamons,Long id){
        Jogador jogador = pegarPorId(id);
        jogador.getStefamons().addAll(stefamons.stream().map(s -> StefamonParser.DtotoEntity(s)).collect(Collectors.toList()));
        jogador.setStefamons(jogador.getStefamons().stream().distinct().collect(Collectors.toList()));
        if(jogador.getStefamons().size() > 6){
            throw new RegraDeNegocioException("Não é possível possuir mais de 6 Stefamons", Response.Status.BAD_REQUEST);
        }
        alterar(jogador);
    }

}
