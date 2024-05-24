package com.felix.clinicaSecurity.service;

import com.felix.clinicaSecurity.domain.Agendamento;
import com.felix.clinicaSecurity.domain.Horario;
import com.felix.clinicaSecurity.repository.AgendamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
public class AgendamentoService {

    @Autowired
    private AgendamentoRepository repository;

    @Transactional(readOnly = true)
    public List<Horario> buscarHorariosNaoAgendadosPorMedicosIdEData(Long id, LocalDate data) {
        return repository.findByMedicoIdAndDataNotHorarioAgendado(id, data);
    }

    @Transactional(readOnly = false)
    public void salvar(Agendamento agendamento) {
        repository.save(agendamento);
    }
}
