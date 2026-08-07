package com.mycompany.PI2.Ativ9.controller;

import com.mycompany.PI2.Ativ9.model.Produto;
import com.mycompany.PI2.Ativ9.service.ProdutoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoService service;

    public ProdutoController(ProdutoService service) {
        this.service = service;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("produtos", service.listar());
        return "produtos";
    }

    @PostMapping("/salvar")
    public String salvar(Produto produto) {
        service.salvar(produto);
        return "redirect:/produtos";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Long id) {
        service.excluir(id);
        return "redirect:/produtos";
    }
}
