package com.mycompany.PI2.Ativ9.service;

import com.mycompany.PI2.Ativ9.model.Produto;
import com.mycompany.PI2.Ativ9.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    private final ProdutoRepository repository;

    public ProdutoService(ProdutoRepository repository) {
        this.repository = repository;
    }

    public List<Produto> listar() {
        return repository.findAll();
    }

    public Produto salvar(Produto produto) {
        return repository.save(produto);
    }

    public void excluir(Long id) {
        repository.deleteById(id);
    }

    public Produto buscarPorId(Long id) {
        return repository.findById(id).orElse(null);
    }
}