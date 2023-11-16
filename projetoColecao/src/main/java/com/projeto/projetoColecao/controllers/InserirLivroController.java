package com.projeto.projetoColecao.controllers;

import com.projeto.projetoColecao.dtos.ListaLivroDto;
import com.projeto.projetoColecao.services.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

@Controller
@RequestMapping("inserirlivro")
public class InserirLivroController {

    @Autowired
    private LivroService livroService;

    @GetMapping()
    public String exibirInserirLivro(Model model){

        ListaLivroDto listaLivroDto = new ListaLivroDto();

        model.addAttribute("ListaLivroDto", listaLivroDto);

        return "inserirlivro";

    }

    @PostMapping
    public String inserirLivro(@ModelAttribute("ListaLivroDto") ListaLivroDto listaLivroDto){

        boolean retorno = livroService.inserirLivro(listaLivroDto);

        if(retorno){
            return "redirect:inserirlivro?sucesso";
        }else{
            return "redirect:inserirlivro?erro";
        }
    }
}
