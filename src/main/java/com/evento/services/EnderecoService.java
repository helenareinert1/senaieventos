package com.evento.services;

import com.evento.dtos.CidadeDTO;
import com.evento.dtos.EnderecoDTO;
import com.evento.models.Cidade;
import com.evento.models.Endereco;
import com.evento.repositories.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnderecoService {
    @Autowired
    private EnderecoRepository enderecoRepository;

    public EnderecoDTO cadastrarEndereco(EnderecoDTO enderecoDTO) {
        Endereco endereco = converterEnderecoDTOParaEndereco(enderecoDTO);
        cidade = enderecoRepository.save(endereco);
        return converterEnderecoParaEnderecoDTO(endereco);

    }
}

    public Endereco converterEnderecoDTOParaEndereco(EnderecoDTO enderecoDTO) {
    Endereco endereco = new Endereco();
    endereco.setId(enderecoDTO.getId());
    endereco.setNumero(enderecoDTO.getNumero());
    endereco.setCep(enderecoDTO.getCep());
    endereco.setRua(enderecoDTO.getRua());
    endereco.setBairro(enderecoDTO.getBairro());
    endereco.setComplemento(enderecoDTO.getComplemento());
    endereco.setCidade(enderecoDTO.getCidade());
    return endereco;
}
