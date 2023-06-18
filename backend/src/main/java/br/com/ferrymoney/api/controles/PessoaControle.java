package br.com.ferrymoney.api.controles;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
