package com.mycompany.PI2.Ativ9.service;

import com.mycompany.PI2.Ativ9.model.Fornecedor;
import com.mycompany.PI2.Ativ9.repository.FornecedorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FornecedorService {

    private final FornecedorRepository repository;

    public FornecedorService(FornecedorRepository repository) {
        this.repository = repository;
    }

    public List<Fornecedor> listar() {
        return repository.findAll();
    }

    public Fornecedor salvar(Fornecedor fornecedor) {
        return repository.save(fornecedor);
    }

    public void excluir(Long id) {
        repository.deleteById(id);
    }

    public Fornecedor buscarPorId(Long id) {
        return repository.findById(id).orElse(null);
    }
}