package br.com.zup.edu.album;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Imagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String descricao;

    @Column(nullable = false)
    private String link;

    @Column(nullable = false)
    private LocalDateTime dataCriacao = LocalDateTime.now();

    public Imagem(String descricao, String link) {
        this.descricao = descricao;
        this.link = link;
    }

    public Imagem() {
    }

    public Long getId() {
        return id;
    }
}
