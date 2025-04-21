package org.example.localizei.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "produto")
public class ProdutoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private String codigoDeRastreio;
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private UsuarioEntity usuario;

}
