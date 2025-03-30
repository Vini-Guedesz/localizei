package org.example.localizei.repository;

import org.example.localizei.entities.ProdutoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProdutoRepository extends JpaRepository<ProdutoEntity, UUID> {

}
