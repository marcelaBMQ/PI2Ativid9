package com.mycompany.PI2.Ativ9;

import com.mycompany.PI2.Ativ9.model.Fornecedor;
import com.mycompany.PI2.Ativ9.model.Produto;
import com.mycompany.PI2.Ativ9.model.Venda;
import com.mycompany.PI2.Ativ9.repository.FornecedorRepository;
import com.mycompany.PI2.Ativ9.repository.ProdutoRepository;
import com.mycompany.PI2.Ativ9.repository.VendaRepository;
import com.mycompany.PI2.Ativ9.service.FornecedorService;
import com.mycompany.PI2.Ativ9.service.ProdutoService;
import com.mycompany.PI2.Ativ9.service.VendaService;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ApplicationTests {

    @Test
    void deveSalvarProduto() {

        ProdutoRepository repository = mock(ProdutoRepository.class);
        ProdutoService service = new ProdutoService(repository);

        Produto produto = new Produto(
                "Notebook",
                "Dell",
                "Fornecedor A"
        );

        when(repository.save(produto)).thenReturn(produto);

        Produto resultado = service.salvar(produto);

        assertNotNull(resultado);
        assertEquals("Notebook", resultado.getNome());

        verify(repository).save(produto);
    }

    @Test
    void deveListarProdutos() {

        ProdutoRepository repository = mock(ProdutoRepository.class);
        ProdutoService service = new ProdutoService(repository);

        Produto produto = new Produto(
                "Mouse",
                "Logitech",
                "Fornecedor A"
        );

        when(repository.findAll()).thenReturn(List.of(produto));

        List<Produto> resultado = service.listar();

        assertEquals(1, resultado.size());
        assertEquals("Mouse", resultado.get(0).getNome());

        verify(repository).findAll();
    }

    @Test
    void deveSalvarFornecedor() {

        FornecedorRepository repository = mock(FornecedorRepository.class);
        FornecedorService service = new FornecedorService(repository);

        Fornecedor fornecedor = new Fornecedor(
                "Fornecedor A",
                "16999999999"
        );

        when(repository.save(fornecedor)).thenReturn(fornecedor);

        Fornecedor resultado = service.salvar(fornecedor);

        assertNotNull(resultado);
        assertEquals("Fornecedor A", resultado.getNome());

        verify(repository).save(fornecedor);
    }

    @Test
    void deveSalvarVenda() {

        VendaRepository repository = mock(VendaRepository.class);
        VendaService service = new VendaService(repository);

        Venda venda = new Venda(
                "Notebook",
                "Mercado Livre",
                2500.00,
                "09/08/2026"
        );

        when(repository.save(venda)).thenReturn(venda);

        Venda resultado = service.salvar(venda);

        assertNotNull(resultado);
        assertEquals("Notebook", resultado.getProduto());
        assertEquals(2500.00, resultado.getValor());

        verify(repository).save(venda);
    }

    @Test
    void deveExcluirProduto() {

        ProdutoRepository repository = mock(ProdutoRepository.class);
        ProdutoService service = new ProdutoService(repository);

        service.excluir(1L);

        verify(repository).deleteById(1L);
    }
}