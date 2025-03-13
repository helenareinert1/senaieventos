package com.evento.enums;

public enum Pefil {
    ADMINISTRADOR("Administrador"),
    FUNCIONARIO("Funcionario"),
    GERENTE("Gerente");

    private String descricao;

    Pefil(String descricao) {
        this.descricao = descricao;
    }
    public String getDescricao() {
        return descricao;
    }
}
