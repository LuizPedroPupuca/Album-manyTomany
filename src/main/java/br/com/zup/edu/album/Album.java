package br.com.zup.edu.album;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
public class Album {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String descricao;

    @ManyToMany(cascade = {CascadeType.MERGE})
    private Set<Imagem> imagens = new HashSet<>();

    @Column(nullable = false)
    private LocalDateTime dataCriacao = LocalDateTime.now();

    public Album(String descricao) {
        this.descricao = descricao;
    }

    @Deprecated
    public Album() {
    }

    public Long getId() {
        return id;
    }

    public void adicionaImagem(Set<ImagemRequest> imagensRequest) {
        this.imagens.addAll(imagensRequest.stream()
                .map(i -> new Imagem(i.getDescricao(),i.getDescricao())).collect(Collectors.toSet()));
    }
}
