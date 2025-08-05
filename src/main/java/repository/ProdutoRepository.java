package com.jocca.springboot_product_crud.repository;

import com.jocca.springboot_product_crud.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}