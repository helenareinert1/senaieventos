package com.evento.models;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "endereco")
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String numero;
    private String cep;
    private String rua;
    private String bairro;
    private String complemento;

    @ManyToOne
    @JoinColumn(name = "cidade_id")
    private Cidade cidade;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Endereco endereco = (Endereco) o;
        return Objects.equals(id, endereco.id) && Objects.equals(numero, endereco.numero) && Objects.equals(cep, endereco.cep) && Objects.equals(rua, endereco.rua) && Objects.equals(bairro, endereco.bairro) && Objects.equals(complemento, endereco.complemento) && Objects.equals(cidade, endereco.cidade);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, numero, cep, rua, bairro, complemento, cidade);
    }
}


