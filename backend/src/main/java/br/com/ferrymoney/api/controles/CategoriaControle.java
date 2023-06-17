package br.com.ferrymoney.api.controles;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.ferrymoney.api.entidades.Categoria;
import br.com.ferrymoney.api.servicos.CategoriaServico;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/categorias")
public class CategoriaControle {

    private final CategoriaServico categoriaServico;

    @GetMapping
    public ResponseEntity<List<Categoria>> buscaTodas() {
        return ResponseEntity.ok(categoriaServico.buscaTodas());
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<Categoria> buscaTodas(@PathVariable Long codigo) {
        return ResponseEntity.ok(categoriaServico.buscaUma(codigo));
    }

    @PostMapping
    public ResponseEntity<Categoria> inserir(@RequestBody Categoria categoria, UriComponentsBuilder uri) {
        Categoria salva = categoriaServico.inserir(categoria);
        URI link = uri.path("/categorias/{id}").buildAndExpand(salva.getCodigo()).toUri();

        return ResponseEntity.created(link).body(salva);
    }
}
