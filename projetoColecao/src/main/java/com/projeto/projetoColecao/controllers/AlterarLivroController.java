package com.projeto.projetoColecao.controllers;

import com.projeto.projetoColecao.dtos.ListaLivroDto;
import com.projeto.projetoColecao.services.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/alterarlivro")
public class AlterarLivroController {

    @Autowired
    private LivroService livroService;

    @GetMapping("/{id}")
    public String exibirTelaAlteracao(Model model, @PathVariable Long id){

        ListaLivroDto livroDto = livroService.obterLivro(id);

        model.addAttribute("editarDto", livroDto);

        return "alterarlivro";
    }

    @PostMapping()
    public String alterarLivro(@ModelAttribute("editarDto") ListaLivroDto listaLivroDto){

        boolean retorno = livroService.alterarLivro(listaLivroDto);

        if(retorno){
            return "redirect:listalivro";
        }else{
            return "redirect:alterarlivro?erro";
        }
    }

}
