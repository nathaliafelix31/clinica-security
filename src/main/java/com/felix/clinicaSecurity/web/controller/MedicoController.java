package com.felix.clinicaSecurity.web.controller;

import com.felix.clinicaSecurity.domain.Medico;
import com.felix.clinicaSecurity.domain.Usuario;
import com.felix.clinicaSecurity.service.MedicoService;
import com.felix.clinicaSecurity.service.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.security.core.userdetails.User;


@Controller
@RequestMapping("medicos")
public class MedicoController {

    @Autowired
    private MedicoService service;
    @Autowired
    private UsuarioService usuarioService;


    // abrir pagina de dados pessoais de medicos pelo MEDICO
    @GetMapping({"/dados"})
    public String abrirPorMedico(Medico medico, ModelMap model){
        return "medico/cadastro";
    }

    //salvar medico
    @PostMapping({"/salvar"})
    public String salvar(Medico medico, RedirectAttributes attr, @AuthenticationPrincipal User user){
        if(medico.hasNotId() && medico.getUsuario().hasNotId()){
            Usuario usuario = usuarioService.buscarPorEmail(user.getUsername());
            medico.setUsuario(usuario);
        }

        service.salvar(medico);
        attr.addFlashAttribute("sucesso", "Operação realizada com sucesso.");
        attr.addFlashAttribute("medico", medico);
        return "redirect:/medicos/dados";

    }

    // editar medico
    @PostMapping({"/editar"})
    public String editar(Medico medico, RedirectAttributes attr){
        service.editar(medico);
        attr.addFlashAttribute("sucesso", "Operação realizada com sucesso.");
        attr.addFlashAttribute("medico", medico);
        return "redirect:/medicos/dados";    }
}
