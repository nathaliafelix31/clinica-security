package com.felix.clinicaSecurity.web.controller;

import com.felix.clinicaSecurity.domain.Agendamento;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("agendamentos")
public class AgendamentoController {

    @GetMapping({"/agendar"})
    public String agendarConsulta(Agendamento agendar){
        return "agendamento/cadastro";
    }
}
