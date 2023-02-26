package com.stefanini.parser;

import com.stefanini.dto.StefamonDTO;
import com.stefanini.entity.Stefamon;

public class StefamonParser {

    public static Stefamon DtotoEntity(StefamonDTO dto) {
        Stefamon stefamon = new Stefamon();
        stefamon.setNome(dto.nome);
        stefamon.setVida(dto.vida);
        stefamon.setAtaque(dto.ataque);
        stefamon.setDefesa(dto.defesa);
        stefamon.setInteligencia(dto.inteligencia);
        stefamon.setPoder(dto.poder);
        stefamon.setVelocidade(dto.velocidade);
        stefamon.setUrlFoto(dto.urlFoto);
        return stefamon;
    }

    public static StefamonDTO EntitytoDto(Stefamon stefamon) {
        StefamonDTO dto = new StefamonDTO();
        dto.nome = stefamon.getNome();
        dto.vida = stefamon.getVida();
        dto.ataque = stefamon.getAtaque();
        dto.defesa = stefamon.getDefesa();
        dto.inteligencia = stefamon.getInteligencia();
        dto.poder = stefamon.getPoder();
        dto.velocidade = stefamon.getVelocidade();
        dto.urlFoto = stefamon.getUrlFoto();
        return dto;
    }

}
