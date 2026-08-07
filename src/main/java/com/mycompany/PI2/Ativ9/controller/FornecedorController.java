package com.mycompany.PI2.Ativ9.controller;

import com.mycompany.PI2.Ativ9.model.Fornecedor;
import com.mycompany.PI2.Ativ9.service.FornecedorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/fornecedores")
public class FornecedorController {

    private final FornecedorService service;

    public FornecedorController(FornecedorService service) {
        this.service = service;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("fornecedores", service.listar());
        return "fornecedores";
    }

    @PostMapping("/salvar")
    public String salvar(Fornecedor fornecedor) {
        service.salvar(fornecedor);
        return "redirect:/fornecedores";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Long id) {
        service.excluir(id);
        return "redirect:/fornecedores";
    }
}