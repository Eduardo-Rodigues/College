package com.example.app_api_paises_novo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PaisDto {
    //instanciando
    @JsonProperty("Código")
    private int codigo;
    @JsonProperty("Descrição")
    private String descricao;

    //getters e setters PaisDto
    public int getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }


}
