package com.mycompany.PI2.Ativ9.repository;

import com.mycompany.PI2.Ativ9.model.Venda;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VendaRepository extends JpaRepository<Venda, Long> {

    List<Venda> findByProdutoContainingIgnoreCase(String produto);

    List<Venda> findByPlataformaContainingIgnoreCase(String plataforma);

    List<Venda> findByDataVenda(String dataVenda);
}