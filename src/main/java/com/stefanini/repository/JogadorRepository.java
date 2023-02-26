package com.stefanini.repository;

import javax.enterprise.context.ApplicationScoped;

import com.stefanini.dao.GenericDAO;
import com.stefanini.entity.Jogador;

@ApplicationScoped
public class JogadorRepository extends GenericDAO<Jogador, Long> {
    public Jogador findByNickName(String nickname) {
        return createQuery("SELECT j from Jogador where j.nickname = :nickname")
        .setParameter("nickname",nickname)
        .getSingleResult();
    }

    public Jogador findByNickNameAndSenha(String nickname,String senha) {
        return createQuery("SELECT j from Jogador where j.nickname = :nickname and j.senha = :senha")
       .setParameter("nickname",nickname)
       .setParameter("senha",senha)
       .getSingleResult();
    }
}
