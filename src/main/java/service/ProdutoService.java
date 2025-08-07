package com.jocca.springboot_product_crud.service;

import com.jocca.springboot_product_crud.model.Produto;
import com.jocca.springboot_product_crud.repository.ProdutoRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import com.jocca.springboot_product_crud.DTO.ProdutoDTO;


import java.util.List;

@Service
public class ProdutoService {

    private final ProdutoRepository repository;

    public ProdutoService(ProdutoRepository repository) {
        this.repository = repository;
    }

    public List<Produto> listar() {
        return repository.findAll();
    }

    public Produto salvar(Produto produto) {
        return repository.save(produto);
    }

    public Produto atualizarProduto(Long id, ProdutoDTO dto) {
        Produto produto = repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não encontrado"));

        produto.setNome(dto.getNome());
        produto.setPreco(dto.getPreco());
        produto.setQuantidade(dto.getQuantidade());

        return repository.save(produto);
    }


    public void deletar(Long id) {
        repository.findById(id).orElseThrow(() ->
            new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não encontrado"));

        repository.deleteById(id);
    }

}
