package com.felix.clinicaSecurity.repository.projection;

import com.felix.clinicaSecurity.domain.Especialidade;
import com.felix.clinicaSecurity.domain.Medico;
import com.felix.clinicaSecurity.domain.Paciente;

public interface HistoricoPaciente {

    Long getId();

    Paciente getPaciente();

    String getDataConsulta();

    Medico getMedico();

    Especialidade getEspecialidade();
}
