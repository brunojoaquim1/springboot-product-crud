package com.jocca.springboot_product_crud.service;

import com.jocca.springboot_product_crud.model.Produto;
import com.jocca.springboot_product_crud.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

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

    public Produto atualizar(Long id, Produto novo) {
        Produto existente = repository.findById(id).orElseThrow();
        existente.setNome(novo.getNome());
        existente.setPreco(novo.getPreco());
        existente.setQuantidade(novo.getQuantidade());
        return repository.save(existente);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
