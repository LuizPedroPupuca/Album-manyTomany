package br.com.zup.edu.album;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import java.util.Set;

public class ImagemRequest {

    @NotBlank
    private String descricao;

    @NotBlank
    private String link;

    public ImagemRequest(String descricao, String link) {
        this.descricao = descricao;
        this.link = link;
    }

    public ImagemRequest() {
    }

    public String getDescricao() {
        return descricao;
    }

    public String getLink() {
        return link;
    }
}
