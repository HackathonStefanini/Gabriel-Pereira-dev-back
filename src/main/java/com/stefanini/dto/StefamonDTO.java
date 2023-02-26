package com.stefanini.dto;

import com.stefanini.entity.Stefamon;

public class StefamonDTO {

    public Long id;
    public String nome;
    public Integer vida;
    public Integer ataque;
    public Integer defesa;
    public Integer inteligencia;
    public Integer poder;
    public Integer velocidade;
    public String urlFoto;

    public StefamonDTO() {
    }

    public StefamonDTO(Integer vida, Integer ataque, Integer defesa, Integer inteligencia,Integer poder,Integer velocidade,String urlFoto){
        this.vida = vida;
        this.ataque = ataque;
        this.defesa = defesa;
        this.inteligencia = inteligencia;
        this.poder = poder;
        this.velocidade = velocidade;
        this.urlFoto = urlFoto;
    }

    public StefamonDTO(Stefamon stefamon){
        this.id = stefamon.getId();
        this.nome = stefamon.getNome();
        this.vida = stefamon.getVida();
        this.ataque = stefamon.getAtaque();
        this.defesa = stefamon.getDefesa();
        this.inteligencia = stefamon.getInteligencia();
        this.poder = stefamon.getPoder();
        this.velocidade = stefamon.getVelocidade();
        this.urlFoto = stefamon.getUrlFoto();
    }
}
