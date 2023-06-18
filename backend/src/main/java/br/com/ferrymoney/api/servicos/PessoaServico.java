package br.com.ferrymoney.api.servicos;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.ferrymoney.api.entidades.Pessoa;
import br.com.ferrymoney.api.repositorios.PessoaRepositorio;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PessoaServico {

    private final PessoaRepositorio pessoaRepositorio;

    @Transactional(readOnly = true)
    public List<Pessoa> buscaTodas() {
        return pessoaRepositorio.findAll();
    }
}
