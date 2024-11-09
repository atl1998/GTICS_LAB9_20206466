package com.example.lab9_20206466.controller;

import com.example.lab9_20206466.dao.ComidaDao;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/food")
public class ComidaController {
    final ComidaDao comidaDao;

    public ComidaController(ComidaDao comidaDao) {
        this.comidaDao = comidaDao;
    }

    @GetMapping({"/list", "", "/"})
    public String listarComidas(Model model) {
        model.addAttribute("listaComidas", comidaDao.listar());
        return "list";
    }
}
