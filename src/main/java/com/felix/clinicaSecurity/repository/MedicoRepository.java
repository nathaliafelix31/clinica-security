package com.felix.clinicaSecurity.repository;

import com.felix.clinicaSecurity.domain.Medico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface MedicoRepository extends JpaRepository<Medico, Long> {

    @Query("select m from Medico m where m.usuario.id = :id")
    Optional<Medico> findByUsuarioId(Long id);


    @Query("select m from Medico m where m.usuario.email = :email")
    Optional<Medico> findByUsuarioEmail(String email);

}
