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
@RequestMapping("/inserirescritor")
public class InserirEscritorController {

    @Autowired
    private EscritorService escritorService;

    @GetMapping
    public String exibirInserirEscritor(Model model){

        ListaEscritorDto listaEscritorDto = new ListaEscritorDto();

        model.addAttribute("ListaEscritorDto", listaEscritorDto);

        return "inserirescritor";
    }

    @PostMapping
    public String inserirEscritor(@ModelAttribute("ListaEscritorDto") ListaEscritorDto listaEscritorDto){

        boolean retorno = escritorService.inserirEscritor(listaEscritorDto);

        if(retorno){
            return "redirect:listaescritor";
        }else{
            return "redirect:inserirescritor?erro";
        }
    }
}
