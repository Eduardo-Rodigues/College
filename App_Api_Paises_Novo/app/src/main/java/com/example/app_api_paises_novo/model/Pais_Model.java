package com.example.app_api_paises_novo.model;

public class Pais_Model {
    private int codigo;
    private String nomePais;

    //contrutor Pais_Model();
    public Pais_Model() {
        this.codigo = codigo;
        this.nomePais = nomePais;
    }

    //construtor vazio testar sem ele mais tarde.


    // getters e setters de Pais_Model();
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return nomePais;
    }

    public void setDescricao(String nomePais) {
        this.nomePais = nomePais;
    }
}
