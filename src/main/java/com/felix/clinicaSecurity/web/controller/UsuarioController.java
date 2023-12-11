package com.felix.clinicaSecurity.web.controller;

import com.felix.clinicaSecurity.domain.Medico;
import com.felix.clinicaSecurity.domain.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("u")
public class UsuarioController {

    // abrir cadastro de usuarios (medico/admin/paciente)
    @GetMapping({"//novo/cadastro/usuario"})
    public String cadastroPorAdminParaAdminMedicoPaciente(Usuario usuario){

        return "usuario/cadastro";
    }
}
