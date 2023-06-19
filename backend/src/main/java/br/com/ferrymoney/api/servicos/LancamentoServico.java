package br.com.ferrymoney.api.servicos;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.ferrymoney.api.entidades.Lancamento;
import br.com.ferrymoney.api.repositorios.LancamentoRepositorio;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LancamentoServico {

    private final LancamentoRepositorio lancamentoRepositorio;

    @Transactional(readOnly = true)
    public List<Lancamento> buscaTodos() {
        return lancamentoRepositorio.findAll();
    }

    @Transactional(readOnly = true)
    public Lancamento buscaUm(Long id) {
        return lancamentoRepositorio.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Lancamento com id " + id + " não existe."));
    }
}
