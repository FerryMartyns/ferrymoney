package br.com.ferrymoney.api.controles;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ferrymoney.api.entidades.Lancamento;
import br.com.ferrymoney.api.servicos.LancamentoServico;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/lancamentos")
public class LancamentoControle {

    private final LancamentoServico lancamentoServico;

    @GetMapping
    public ResponseEntity<List<Lancamento>> buscaTodos() {
        return ResponseEntity.ok(lancamentoServico.buscaTodos());
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<Lancamento> buscaUm(@PathVariable Long codigo) {
        return ResponseEntity.ok(lancamentoServico.buscaUm(codigo));
    }
}
