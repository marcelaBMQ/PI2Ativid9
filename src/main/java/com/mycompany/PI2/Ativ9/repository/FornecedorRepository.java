package com.mycompany.PI2.Ativ9.repository;

import com.mycompany.PI2.Ativ9.model.Fornecedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FornecedorRepository extends JpaRepository<Fornecedor, Long> {
}