package com.jocca.springboot_product_crud.controller;

import com.jocca.springboot_product_crud.model.Produto;
import com.jocca.springboot_product_crud.service.ProdutoService;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import jakarta.validation.*;
import java.util.List;
import com.jocca.springboot_product_crud.dto.ProdutoDTO;
import java.util.Map;


@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoService service;

    public ProdutoController(ProdutoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Produto> listar() {
        return service.listar();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Produto> buscarPorId(@PathVariable Long id){
        Produto produto = service.buscarPorId(id);
        return ResponseEntity.ok(produto);
    }

    @PostMapping
    public Produto salvar(@Valid @RequestBody Produto produto) {
        return service.salvar(produto);
    }
    /*
    public Produto atualizar(@PathVariable Long id, @Valid @RequestBody Produto produto){
        return service.atualizar(id, produto);
    }*/

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.ok().body(
        Map.of("mensagem", "OK - Deletado com sucesso")
        );
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<?> atualizarProduto(
            @PathVariable Long id,
            @RequestBody @Valid ProdutoDTO dto) {

        Produto atualizado = service.atualizarProduto(id, dto);
        return ResponseEntity.ok().body(
        Map.of("mensagem", "OK - Atualizado com sucesso")
        );
    }

}
