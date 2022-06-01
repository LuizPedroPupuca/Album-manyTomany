package br.com.zup.edu.album;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/album")
public class AlbumController {

    @Autowired
    private AlbumRepository albumRepository;

    @PostMapping
    public ResponseEntity<Void> cadastraAlbum(@RequestBody @Valid AlbumRequest albumRequest, UriComponentsBuilder uri){
        Album album = albumRequest.toModel();
        albumRepository.save(album);

        URI location = uri.path("/album/{id}").buildAndExpand(album.getId()).toUri();

        return ResponseEntity.created(location).build();

    }

    @PostMapping("{idAlbum}/imagens")
    public ResponseEntity<Void> cadastraImagens(@RequestBody @Valid Set<ImagemRequest> imagensRequest, @PathVariable Long idAlbum, UriComponentsBuilder uri){
        Album album = albumRepository.findById(idAlbum).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Álbum inexistente"));

        album.adicionaImagem(imagensRequest);
        albumRepository.save(album);

        URI location = uri.path("/album/imagens/{id}").buildAndExpand(album.getId()).toUri();

        return ResponseEntity.created(location).build();

    }
}
