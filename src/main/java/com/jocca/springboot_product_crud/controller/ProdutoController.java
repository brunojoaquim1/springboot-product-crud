package com.jocca.springboot_product_crud.controller;

import com.jocca.springboot_product_crud.dto.APIResponse;
import com.jocca.springboot_product_crud.model.Produto;
import com.jocca.springboot_product_crud.service.ProdutoService;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import jakarta.validation.*;

import java.net.URI;
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
    public ResponseEntity<APIResponse<Produto>> salvar(@Valid @RequestBody ProdutoDTO dto) {
        APIResponse<Produto> response = service.salvar(dto);
        URI location = URI.create("/produtos/" + response.getData().getId());
        return ResponseEntity.created(location).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<APIResponse<Void>> deletar(@PathVariable Long id) {
        return ResponseEntity.ok(service.deletar(id));
    }


    @PutMapping("/{id}")
    public ResponseEntity<APIResponse<Void>> atualizarProduto(@PathVariable Long id,
                                                              @Valid @RequestBody ProdutoDTO dto) {
        return ResponseEntity.ok(service.atualizarProduto(id, dto));
    }


}
