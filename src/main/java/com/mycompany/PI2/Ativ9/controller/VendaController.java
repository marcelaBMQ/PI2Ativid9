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

    @GetMapping("/buscar/produto")
    public String buscarPorProduto(
            @RequestParam String produto,
            Model model) {

        model.addAttribute("vendas",
                service.buscarPorProduto(produto));

        return "vendas";
    }

    @GetMapping("/buscar/plataforma")
    public String buscarPorPlataforma(
            @RequestParam String plataforma,
            Model model) {

        model.addAttribute("vendas",
                service.buscarPorPlataforma(plataforma));

        return "vendas";
    }

    @GetMapping("/buscar/data")
    public String buscarPorData(
            @RequestParam String data,
            Model model) {

        model.addAttribute("vendas",
                service.buscarPorData(data));

        return "vendas";
    }
}