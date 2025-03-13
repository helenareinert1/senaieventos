package com.evento.dtos;

import com.evento.models.Cidade;
import jakarta.persistence.*;

import java.util.Objects;


public class EnderecoDTO {
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
        EnderecoDTO that = (EnderecoDTO) o;
        return Objects.equals(id, that.id) && Objects.equals(numero, that.numero) && Objects.equals(cep, that.cep) && Objects.equals(rua, that.rua) && Objects.equals(bairro, that.bairro) && Objects.equals(complemento, that.complemento) && Objects.equals(cidade, that.cidade);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, numero, cep, rua, bairro, complemento, cidade);
    }
}
