package com.projeto.projetoColecao.controllers;

import com.projeto.projetoColecao.dtos.ListaLivroDto;
import com.projeto.projetoColecao.services.LivroService;
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
@RequestMapping("/listalivro")
public class ListaLivroController {

    @Autowired
    private LivroService livroService;

    @GetMapping()
    public String exibirListaLivro(Model model){

        List<ListaLivroDto> listaLivroDto = livroService.obterLivros();

        model.addAttribute("livros", listaLivroDto);

        return "listalivro";
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> excluirLivro(@PathVariable Long id){

        boolean retorno = livroService.excluirLivro(id);

        if(retorno){
            return new ResponseEntity<>("Livro excluído com sucesso.", HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Erro ao excluir livro.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
