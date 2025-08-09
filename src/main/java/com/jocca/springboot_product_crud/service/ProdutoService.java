package com.jocca.springboot_product_crud.service;

import com.jocca.springboot_product_crud.model.Produto;
import com.jocca.springboot_product_crud.repository.ProdutoRepository;
import org.springframework.stereotype.Service;
import com.jocca.springboot_product_crud.dto.ProdutoDTO;
import com.jocca.springboot_product_crud.exception.ProdutoNaoEncontradoException;


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
        Produto produto = repository.findById(id)
                                    .orElseThrow(() -> new ProdutoNaoEncontradoException(id));

        produto.setNome(dto.getNome());
        produto.setPreco(dto.getPreco());
        produto.setQuantidade(dto.getQuantidade());

        return repository.save(produto);
    }
    public void deletar(Long id) {
        Produto produto = repository.findById(id)
                                    .orElseThrow(() -> new ProdutoNaoEncontradoException(id));

        repository.deleteById(id);
    }
    
    public Produto buscarPorId(Long id) {
    return repository.findById(id)
        .orElseThrow(() -> new ProdutoNaoEncontradoException(id));
    }


}
