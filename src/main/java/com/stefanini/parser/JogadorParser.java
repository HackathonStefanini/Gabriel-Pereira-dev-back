package com.stefanini.parser;

import com.stefanini.dto.JogadorDTO;
import com.stefanini.dto.JogadorSemSenhaDTO;
import com.stefanini.entity.Jogador;

public class JogadorParser {
    public static Jogador JogadorDtotoEntity(JogadorDTO dto) {
        Jogador jogador = new Jogador();
        jogador.setId(dto.id);
        jogador.setNickname(dto.nickname);
        jogador.setSenha(dto.senha);
        return jogador;
    }

    public static JogadorDTO EntitytoJogadorDto(Jogador entity) {
        JogadorDTO jogadorDto = new JogadorDTO();
        jogadorDto.id = entity.getId();
        jogadorDto.nickname= entity.getNickname();
        jogadorDto.senha = entity.getSenha();
        return jogadorDto;
    }

    public static Jogador JogadorSemSenhaDtoEntity(JogadorSemSenhaDTO dto) {
        Jogador jogador = new Jogador();
        jogador.setId(dto.id);
        jogador.setNickname(dto.nickname);
        return jogador;
    }

    public static JogadorSemSenhaDTO EntitytoJogadorSemSenhaDto(Jogador entity) {
        JogadorSemSenhaDTO jogadorDto = new JogadorSemSenhaDTO();
        jogadorDto.id = entity.getId();
        jogadorDto.nickname= entity.getNickname();
        jogadorDto.saldo = entity.getSaldo();
        return jogadorDto;
    }

}
