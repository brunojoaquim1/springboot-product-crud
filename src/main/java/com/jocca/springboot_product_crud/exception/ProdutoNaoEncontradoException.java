package com.jocca.springboot_product_crud.exception;

public class ProdutoNaoEncontradoException extends RegraDeNegocioException {
    public ProdutoNaoEncontradoException(Long id) {
        super("Produto com ID " + id + " não encontrado");
    }
}
