package com.mycompany.PI2.Ativ9.service;

import com.mycompany.PI2.Ativ9.model.Venda;
import com.mycompany.PI2.Ativ9.repository.VendaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VendaService {

    private final VendaRepository repository;

    public VendaService(VendaRepository repository) {
        this.repository = repository;
    }

    public List<Venda> listar() {
        return repository.findAll();
    }

    public Venda salvar(Venda venda) {
        return repository.save(venda);
    }

    public void excluir(Long id) {
        repository.deleteById(id);
    }

    public Venda buscarPorId(Long id) {
        return repository.findById(id).orElse(null);
    }
}