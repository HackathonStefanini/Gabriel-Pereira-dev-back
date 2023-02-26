package com.stefanini.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class JogadorDTO {

    public Long id;

    @NotBlank
    public String nickname;

    @NotBlank
    @Size(min = 4,max = 10)
    public String senha;

    public JogadorDTO() {
    }

    public JogadorDTO(Long id,String nickname, String senha) {
        this.id = id;
        this.nickname = nickname;
        this.senha = senha;
    }
}
