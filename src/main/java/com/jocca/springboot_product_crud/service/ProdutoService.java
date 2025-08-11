package com.jocca.springboot_product_crud.service;

import com.jocca.springboot_product_crud.dto.APIResponse;
import com.jocca.springboot_product_crud.model.Produto;
import com.jocca.springboot_product_crud.repository.ProdutoRepository;
import org.springframework.stereotype.Service;
import com.jocca.springboot_product_crud.dto.ProdutoDTO;
import com.jocca.springboot_product_crud.exception.ProdutoNaoEncontradoException;
import org.springframework.transaction.annotation.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Service
public class ProdutoService {

    private final ProdutoRepository repository;
    private static final Logger log = LoggerFactory.getLogger(ProdutoService.class);


    public ProdutoService(ProdutoRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    public List<Produto> listar() {
        return repository.findAll();
    }

    @Transactional
    public APIResponse<Produto> salvar(ProdutoDTO dto) {
        long start = System.currentTimeMillis();
        log.info("action=CREATE entity=Produto nome={}", dto.getNome());

        Produto produto = fromDTO(dto);
        Produto salvo = repository.save(produto);

        log.info("action=CREATE entity=Produto status=success id={} elapsedMs={}",
                salvo.getId(), System.currentTimeMillis() - start);

        return new APIResponse<>("Produto criado com sucesso", salvo);

    }

    @Transactional
    public APIResponse<Void> atualizarProduto(Long id, ProdutoDTO dto) {
        long start = System.currentTimeMillis();
        log.info("action=UPDATE entity=Produto id={}", id);

        Produto produto = repository.findById(id)
                .orElseThrow(() -> new ProdutoNaoEncontradoException(id));

        produto.setNome(dto.getNome());
        produto.setPreco(dto.getPreco());
        produto.setQuantidade(dto.getQuantidade());

        repository.save(produto);
        log.info("action=UPDATE entity=Produto status=success id={} elapsedMs={}",
                id, System.currentTimeMillis() - start);

        return new APIResponse<>("Produto atualizado com sucesso");
    }

    @Transactional
    public APIResponse<Void> deletar(Long id) {
        Produto produto = repository.findById(id)
                .orElseThrow(() -> new ProdutoNaoEncontradoException(id));

        repository.delete(produto);
        log.info("action=DELETE entity=Produto status=success id={}", id);

        return new APIResponse<>("Produto deletado com sucesso");
    }

    @Transactional(readOnly = true)
    public Produto buscarPorId(Long id) {
        log.debug("action=GET entity=Produto id={}", id);
        return repository.findById(id)
                         .orElseThrow(() -> new ProdutoNaoEncontradoException(id));
    }

    private Produto fromDTO(ProdutoDTO dto) {
        Produto p = new Produto();
        p.setNome(dto.getNome());
        p.setPreco(dto.getPreco());
        p.setQuantidade(dto.getQuantidade());
        return p;
    }


}
