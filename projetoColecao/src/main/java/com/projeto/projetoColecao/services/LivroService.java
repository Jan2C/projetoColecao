package com.projeto.projetoColecao.services;

import com.projeto.projetoColecao.dtos.ListaLivroDto;
import com.projeto.projetoColecao.models.EscritorModel;
import com.projeto.projetoColecao.models.LivroModel;
import com.projeto.projetoColecao.repositories.EscritorRepository;
import com.projeto.projetoColecao.repositories.LivroRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    @Autowired
    private EscritorRepository escritorRepository;

    public List<ListaLivroDto>obterLivros(){

        List<LivroModel> livrosModel = livroRepository.findAll();

        List<ListaLivroDto> livrosDto = new ArrayList<>();

        for(LivroModel livroModel : livrosModel){

            ListaLivroDto livroDto = new ListaLivroDto();

            livroDto.setId(livroModel.getLivroId());
            livroDto.setNome(livroModel.getLivroNome());
            livroDto.setEditora(livroModel.getLivroEditora());
            livroDto.setEscritorId(livroModel.getLivroEscritor().getEscritorId());
            livroDto.setGenero(livroModel.getLivroGenero());
            livroDto.setAno(livroModel.getLivroAno());
            livroDto.setPaginas(livroModel.getLivroPaginas());

            livrosDto.add(livroDto);
        }
        return livrosDto;
    }

    public ListaLivroDto obterLivro(Long id){

        Optional<LivroModel> livroModelOptional = livroRepository.findById(id);

        ListaLivroDto listaLivroDto = new ListaLivroDto();

        if(livroModelOptional.isPresent()){

            listaLivroDto.setId(livroModelOptional.get().getLivroId());
            listaLivroDto.setNome(livroModelOptional.get().getLivroNome());
            listaLivroDto.setEditora(livroModelOptional.get().getLivroEditora());
            listaLivroDto.setGenero(livroModelOptional.get().getLivroGenero());
            listaLivroDto.setEscritorId(livroModelOptional.get().getLivroEscritor().getEscritorId());
            listaLivroDto.setAno(livroModelOptional.get().getLivroAno());
            listaLivroDto.setPaginas(livroModelOptional.get().getLivroPaginas());

        }
        return listaLivroDto;
    }

    @Transactional
    public boolean  inserirLivro(ListaLivroDto listaLivroDto){

        LivroModel livroModel = new LivroModel();

        Optional<EscritorModel> escritorModelOptional = escritorRepository.findById(listaLivroDto.getEscritorId());

        if(!escritorModelOptional.isPresent()){
            return false;
        }else{

            livroModel.setLivroNome(listaLivroDto.getNome());
            livroModel.setLivroEditora(listaLivroDto.getEditora());
            livroModel.setLivroAno(listaLivroDto.getAno());
            livroModel.setLivroEscritor(escritorModelOptional.get());
            livroModel.setLivroPaginas(listaLivroDto.getPaginas());
            livroModel.setLivroGenero(listaLivroDto.getGenero());

            livroRepository.save(livroModel);

            return true;
        }
    }

    @Transactional
    public boolean alterarLivro(ListaLivroDto listaLivroDto){

        Optional<LivroModel> livroModelOptional = livroRepository.findById(listaLivroDto.getId());

        Optional<EscritorModel> escritorModelOptional = escritorRepository.findById(listaLivroDto.getEscritorId());

        if(!escritorModelOptional.isPresent()){
            return false;
        }else{

            livroModelOptional.get().setLivroNome(listaLivroDto.getNome());
            livroModelOptional.get().setLivroEditora(listaLivroDto.getEditora());
            livroModelOptional.get().setLivroAno(listaLivroDto.getAno());
            livroModelOptional.get().setLivroEscritor(escritorModelOptional.get());
            livroModelOptional.get().setLivroPaginas(listaLivroDto.getPaginas());
            livroModelOptional.get().setLivroGenero(listaLivroDto.getGenero());

            livroRepository.save(livroModelOptional.get());

            return true;
        }
    }

    @Transactional
    public boolean excluirLivro(Long id){

        livroRepository.deleteById(id);

        return true;
    }
}
