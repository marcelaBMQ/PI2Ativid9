package com.mycompany.PI2.Ativ9.repository;

import com.mycompany.PI2.Ativ9.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}