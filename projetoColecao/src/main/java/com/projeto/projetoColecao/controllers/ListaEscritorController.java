package com.projeto.projetoColecao.controllers;

import com.projeto.projetoColecao.dtos.ListaEscritorDto;
import com.projeto.projetoColecao.services.EscritorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

import java.util.List;

@Controller
@RequestMapping("/listaescritor")
public class ListaEscritorController {

    @Autowired
    private EscritorService escritorService;

    @GetMapping()
    public String exibirListaEscritor(Model model){

        List<ListaEscritorDto> listaEscritores = escritorService.obterEscritores();

        model.addAttribute("escritores", listaEscritores);

        return "listaescritor";
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> excluirEscritor(@PathVariable Long id){

        boolean retorno = escritorService.excluirEscritor(id);

        if(retorno){
            return new ResponseEntity<>("Escritor excluído com sucesso.", HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Erro ao excluir escritor.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
