package org.example.localizei.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
public class ProdutoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(unique = true, nullable = false, name = "id")
    private UUID id;
    @Column(nullable = false, name = "nome")
    private String nome;
    @Column(nullable = false, name = "codigo_de_rastreio")
    private String codigoDeRastreio;
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private UsuarioEntity usuario;

}
