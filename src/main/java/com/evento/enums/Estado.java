package com.evento.enums;

public enum Estado {
    ACRE("Acre"),
    AMAZONAS("Amazonas");


    private String descricao;

    Estado(String descricao) {
        this.descricao = descricao;
    }
    public String getDescricao() {
        return descricao;
    }
}
