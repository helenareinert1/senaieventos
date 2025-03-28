package com.evento.services;

import com.evento.dtos.CidadeDTO;
import com.evento.dtos.UsuarioDTO;
import com.evento.exceptions.BussinesException;
import com.evento.models.Cidade;
import com.evento.models.Usuario;
import com.evento.repositories.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CidadeService {

    private static final String MSG_CIDADE = "Cidade não encontrada";

    @Autowired
    private CidadeRepository cidadeRepository;

    public CidadeDTO cadastrarCidade(CidadeDTO cidadeDTO){
        Cidade cidade = converterCidadeDTOParaCidade(cidadeDTO);
        cidade = cidadeRepository.save(cidade);
        return converterCidadeParaCidadeDTO(cidade);
    }

    public CidadeDTO converterCidadeParaCidadeDTO(Cidade cidade){
        CidadeDTO cidadeDTO = new CidadeDTO(cidade.getId(),
                cidade.getNome(),
                cidade.getEstado());
        return cidadeDTO;
    }

    public Cidade converterCidadeDTOParaCidade(CidadeDTO cidadeDTO){
        Cidade cidade = new Cidade(cidadeDTO.getId(),
                cidadeDTO.getNome(),
                cidadeDTO.getEstado());
        return cidade;
    }

    public void deletarCidade(Long id){
        cidadeRepository.deleteById(id);
    }

    public CidadeDTO buscarCidadePorId(Long id){
        Cidade cidade = cidadeRepository.findById(id)
                .orElseThrow(() ->
                        new BussinesException(MSG_CIDADE));
        return converterCidadeParaCidadeDTO(cidade);
    }

    public CidadeDTO atualizarCidade(CidadeDTO cidadeDTO){
        //Busca a cidade pelo id para ter certeza que ela existe
        cidadeRepository.findById(cidadeDTO.getId())
                .orElseThrow(() ->
                        new BussinesException(MSG_CIDADE));
        //Converte o DTO para a entidade
        Cidade cidade = converterCidadeDTOParaCidade(cidadeDTO);
        //atualiza a cidade no banco
        cidadeRepository.save(cidade);
        //convete a entidade para o DTO
        return converterCidadeParaCidadeDTO(cidade);
    }

    public CidadeDTO buscarCidadePorNome(String nome){
        Cidade cidade = cidadeRepository.findByNome(nome)
                .orElseThrow(() ->
                        new BussinesException(MSG_CIDADE));
        return converterCidadeParaCidadeDTO(cidade);
    }
}