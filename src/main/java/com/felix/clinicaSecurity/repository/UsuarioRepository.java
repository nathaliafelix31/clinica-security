package com.felix.clinicaSecurity.repository;

import com.felix.clinicaSecurity.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    @Query("Select u from Usuario u where u.email like :email")
    Usuario findByEmail(@Param("email") String email);

}
