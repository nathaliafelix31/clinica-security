package com.felix.clinicaSecurity.web.controller;

import com.felix.clinicaSecurity.domain.Usuario;
import com.felix.clinicaSecurity.service.UsuarioService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("u")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    // abrir cadastro de usuarios (medico/admin/paciente)
    @GetMapping({"/novo/cadastro/usuario"})
    public String cadastroPorAdminParaAdminMedicoPaciente(Usuario usuario){

        return "usuario/cadastro";
    }

    //abrir lista de usuarios
    @GetMapping("/lista")
    public String listarUsuarios(){
        return "usuario/lista";
    }

    //listar usuarios na datatables
    @GetMapping("/datatables/server/usuarios")
    public ResponseEntity<?> listarUsuariosDatatables(HttpServletRequest request){

        return ResponseEntity.ok(service.buscarTodos(request));
    }

}
