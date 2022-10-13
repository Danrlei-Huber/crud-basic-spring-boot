package com.example.project.model.repositories;

import com.example.project.model.entities.Produto;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ProdutoRepository extends PagingAndSortingRepository<Produto,Integer> {

    public Iterable<Produto> findByNomeContaining(String parteNome);

}



