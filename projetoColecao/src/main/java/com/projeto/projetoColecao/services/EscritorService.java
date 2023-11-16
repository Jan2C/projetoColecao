package com.projeto.projetoColecao.services;

import com.projeto.projetoColecao.dtos.ListaEscritorDto;
import com.projeto.projetoColecao.models.EscritorModel;
import com.projeto.projetoColecao.repositories.EscritorRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EscritorService {

    @Autowired
    private EscritorRepository escritorRepository;

    public List<ListaEscritorDto> obterEscritores(){

        List<EscritorModel> escritoresModel = escritorRepository.findAll();

        List<ListaEscritorDto> escritoresDto = new ArrayList<>();

        for(EscritorModel escritorModel : escritoresModel){

            ListaEscritorDto escritorDto = new ListaEscritorDto();

            escritorDto.setId(escritorModel.getEscritorId());
            escritorDto.setNome(escritorModel.getNome());
            escritorDto.setDataNascMorte(escritorModel.getDataNascMorte());
            escritorDto.setGeneroLiterario(escritorModel.getGeneroLiterario());

            escritoresDto.add(escritorDto);
        }
        return escritoresDto;
    }

    public ListaEscritorDto obterEscritor(ListaEscritorDto listaEscritorDto){

        Optional<EscritorModel> escritorModelOptional = escritorRepository.findById(listaEscritorDto.getId());

        listaEscritorDto.setNome(escritorModelOptional.get().getNome());
        listaEscritorDto.setGeneroLiterario(escritorModelOptional.get().getGeneroLiterario());
        listaEscritorDto.setDataNascMorte(escritorModelOptional.get().getDataNascMorte());

        return listaEscritorDto;
    }

    @Transactional
    public boolean inserirEscritor(ListaEscritorDto listaEscritorDto){

        EscritorModel escritorModel = new EscritorModel();

        escritorModel.setNome(listaEscritorDto.getNome());
        escritorModel.setDataNascMorte(listaEscritorDto.getDataNascMorte());
        escritorModel.setGeneroLiterario(listaEscritorDto.getGeneroLiterario());

        escritorRepository.save(escritorModel);

        return true;
    }

    @Transactional
    public boolean alterarEscritor(ListaEscritorDto listaEscritorDto){

        Optional<EscritorModel> escritorModelOptional = escritorRepository.findById(listaEscritorDto.getId());

        escritorModelOptional.get().setNome(listaEscritorDto.getNome());
        escritorModelOptional.get().setGeneroLiterario(listaEscritorDto.getGeneroLiterario());
        escritorModelOptional.get().setDataNascMorte(listaEscritorDto.getDataNascMorte());

        escritorRepository.save(escritorModelOptional.get());

        return true;
    }

    @Transactional
    public boolean excluirEscritor(Long id){

        escritorRepository.deleteById(id);

        return true;
    }
}
