package com.mycompany.PI2.Ativ9.controller;

import com.mycompany.PI2.Ativ9.model.Venda;
import com.mycompany.PI2.Ativ9.service.VendaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/vendas")
public class VendaController {

    private final VendaService service;

    public VendaController(VendaService service) {
        this.service = service;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("vendas", service.listar());
        return "vendas";
    }

    @PostMapping("/salvar")
    public String salvar(Venda venda) {
        service.salvar(venda);
        return "redirect:/vendas";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Long id) {
        service.excluir(id);
        return "redirect:/vendas";
    }
}