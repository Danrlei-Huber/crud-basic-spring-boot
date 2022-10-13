package com.example.project.controllers;

import com.example.project.model.entities.Produto;
import com.example.project.model.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @PostMapping
    public @ResponseBody Produto novoProduto(@Valid Produto produto){

        produtoRepository.save(produto);

        return produto;
    }

    @GetMapping
    public Iterable<Produto> obterProdutos(){
        return produtoRepository.findAll();
    }

    @GetMapping(path = "/nome/{parteNome}")
    public Iterable<Produto> obterProdutosPorNome(@PathVariable String parteNome){
        return produtoRepository.findByNomeContaining(parteNome);
    }

    @GetMapping(path = "/pagina/{numeroPagina}/{qtdPagina}")
    public Iterable<Produto> obterProdutosPorPagina(@PathVariable int numeroPagina, @PathVariable int qtdPagina){
        if (qtdPagina >= 4) qtdPagina = 2;
        Pageable page = PageRequest.of(numeroPagina, qtdPagina);
        return produtoRepository.findAll(page);
    }

    @GetMapping(path = "/{id}")
    public Optional<Produto> obterProdutoPorId(@PathVariable int id){
        return produtoRepository.findById(id);
    }

    @PutMapping
    public Produto alterarProduto(@Valid Produto produto){
        produtoRepository.save(produto);
        return produto;
    }

    @DeleteMapping(path = "/{id}")
    public void excluirProduto(@PathVariable int id){
        produtoRepository.deleteById(id);
    }

}
