package br.com.ferrymoney.api.controles;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.ferrymoney.api.entidades.Pessoa;
import br.com.ferrymoney.api.servicos.PessoaServico;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/pessoas")
public class PessoaControle {

    private final PessoaServico pessoaServico;

    @GetMapping
    public ResponseEntity<List<Pessoa>> buscaTodas() {
        return ResponseEntity.ok(pessoaServico.buscaTodas());
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<Pessoa> buscaUm(@PathVariable Long codigo) {
        return ResponseEntity.ok(pessoaServico.buscaUm(codigo));
    }

    @PostMapping
    public ResponseEntity<Pessoa> cadastra(@Valid @RequestBody Pessoa pessoa, UriComponentsBuilder uri) {
        Pessoa salva = pessoaServico.cadastra(pessoa);
        URI link = uri.path("/pessoas/{id}").buildAndExpand(salva.getCodigo()).toUri();

        return ResponseEntity.created(link).body(salva);
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<Void> exclui(@PathVariable Long codigo) {
        pessoaServico.exclui(codigo);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{codigo}")
    public ResponseEntity<Pessoa> atualiza(@Valid @RequestBody Pessoa pessoa, @PathVariable Long codigo){
        return ResponseEntity.ok(pessoaServico.atualiza(codigo, pessoa));
    }

    @PutMapping("/{codigo}/ativo")
    public ResponseEntity<Void> atualizaAtivo(@PathVariable Long codigo, @RequestBody Boolean flag){
        pessoaServico.atualizaAtivo(codigo, flag);
        return ResponseEntity.noContent().build();
    }
}
