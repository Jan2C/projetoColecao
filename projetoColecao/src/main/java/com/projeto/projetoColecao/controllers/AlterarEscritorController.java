package com.projeto.projetoColecao.controllers;

import com.projeto.projetoColecao.dtos.ListaEscritorDto;
import com.projeto.projetoColecao.services.EscritorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/alterarescritor")
public class AlterarEscritorController {

    @Autowired
    private EscritorService escritorService;

    @GetMapping
    public String exibirAlterarEscritor(Model model, ListaEscritorDto listaEscritorDto){

        ListaEscritorDto escritorDto = escritorService.obterEscritor(listaEscritorDto);

        model.addAttribute("ListaEscritorDto", escritorDto);

        return "alterarescritor";
    }

    @PostMapping
    public String alterarEscritor(@ModelAttribute("ListaEscritorDto") ListaEscritorDto listaEscritorDto){

        boolean retorno = escritorService.alterarEscritor(listaEscritorDto);

        if(retorno){
            return "redirect:listaescritor";
        }else{
            return "redirect:alterarescritor?erro";
        }
    }
}
