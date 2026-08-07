package com.mycompany.PI2.Ativ9.repository;

import com.mycompany.PI2.Ativ9.model.Venda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface VendaRepository extends JpaRepository<Venda, Long> {
}