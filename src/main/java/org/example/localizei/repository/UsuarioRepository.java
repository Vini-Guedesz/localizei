package org.example.localizei.repository;

import org.example.localizei.entities.UsuarioEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, UUID> {
    Optional<UsuarioEntity> findByEmail(String email);
    Optional<UsuarioEntity> findById(UUID id);
    Page<UsuarioEntity> findAll(Pageable pageable);
}
