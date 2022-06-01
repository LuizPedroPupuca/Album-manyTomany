package br.com.zup.edu.album;

import javax.persistence.Column;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.HashSet;
import java.util.Set;

public class AlbumRequest {

    @NotBlank
    private String descricao;

    public AlbumRequest(String descricao) {
        this.descricao = descricao;
    }

    public AlbumRequest() {
    }

    public String getDescricao() {
        return descricao;
    }

    public Album toModel() {
        return new Album(descricao);
    }
}
