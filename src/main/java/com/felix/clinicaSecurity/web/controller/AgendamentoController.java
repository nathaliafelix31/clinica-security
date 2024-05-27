package com.felix.clinicaSecurity.web.controller;

import com.felix.clinicaSecurity.domain.Agendamento;
import com.felix.clinicaSecurity.domain.Especialidade;
import com.felix.clinicaSecurity.domain.Paciente;
import com.felix.clinicaSecurity.domain.PerfilTipo;
import com.felix.clinicaSecurity.service.AgendamentoService;
import com.felix.clinicaSecurity.service.EspecialidadeService;
import com.felix.clinicaSecurity.service.PacienteService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;

@Controller
@RequestMapping("agendamentos")
public class AgendamentoController {

    @Autowired
    private AgendamentoService service;

    @Autowired
    private PacienteService pacienteService;

    @Autowired
    private EspecialidadeService especialidadeService;

    @GetMapping({"/agendar"})
    public String agendarConsulta(Agendamento agendar){
        return "agendamento/cadastro";
    }

    @GetMapping("/horario/medico/{id}/data/{data}")
    public ResponseEntity<?> getHorarios(@PathVariable("id") Long id,
                                         @PathVariable("data") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate data){
        return ResponseEntity.ok(service.buscarHorariosNaoAgendadosPorMedicosIdEData(id, data));
    }

    @PostMapping({"/salvar"})
    public String salvar(Agendamento agendamento, RedirectAttributes attr, @AuthenticationPrincipal User user){
        Paciente paciente = pacienteService.buscarPorUsuarioEmail(user.getUsername());
        String titulo = agendamento.getEspecialidade().getTitulo();
        Especialidade especialidade = especialidadeService
                .buscarPorTitulos(new String[] {titulo})
                .stream().findFirst().get();
        agendamento.setEspecialidade(especialidade);
        agendamento.setPaciente(paciente);
        service.salvar(agendamento);
        attr.addFlashAttribute("sucesso", "Sua consulta foi agendada com sucesso");
        return "redirect:/agendamentos/agendar";
    }

    // abrir pagina de historico de agendamento do paciente
    @GetMapping({"/historico/paciente", "/historico/consultas"})
    public String historico(){
        return "agendamento/historico-paciente";
    }

    // localizar o historico de agendamentos por usuario logado
    @GetMapping("/datatables/server/historico")
    public ResponseEntity<?> historicoAgendamentosPorPaciente(HttpServletRequest request, @AuthenticationPrincipal User user){
        if(user.getAuthorities().contains(new SimpleGrantedAuthority(PerfilTipo.PACIENTE.getDesc()))){
            return ResponseEntity.ok(service.buscarHistoricoPorPacienteEmail(user.getUsername(), request));
        }
        if(user.getAuthorities().contains(new SimpleGrantedAuthority(PerfilTipo.MEDICO.getDesc()))){
            return ResponseEntity.ok(service.buscarHistoricoPorMedicoEmail(user.getUsername(), request));
        }
        return ResponseEntity.notFound().build();
    }
}
