package com.jocca.springboot_product_crud.dto;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

public class ProdutoDTO {

    @NotBlank(message = "Nome é obrigatório")
    private String nome;

    @DecimalMin(value = "0.01", message = "Preço deve ser maior que zero")
    private double preco;

    @Min(value = 1, message = "Quantidade deve ser maior que zero")
    private int quantidade;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
    
    
}