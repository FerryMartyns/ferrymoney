package br.com.ferrymoney.api.servicos;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.BeanUtils;
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

    @Transactional(readOnly = true)
    public Pessoa buscaUm(Long id) {
        return buscaPessoaPorId(id);
    }

    @Transactional
    public Pessoa cadastra(Pessoa pessoa) {
        return persistePessoa(pessoa);
    }

    @Transactional
    public void exclui(Long id) {
        Pessoa pessoa = buscaPessoaPorId(id);
        pessoaRepositorio.delete(pessoa);
    }

    @Transactional
    public Pessoa atualiza(Long id, Pessoa pessoa) {
        Pessoa pessoaSalva = buscaPessoaPorId(id);
        BeanUtils.copyProperties(pessoa, pessoaSalva, "codigo");
        return persistePessoa(pessoaSalva);
    }

    @Transactional
    public void atualizaAtivo(Long codigo, Boolean flag) {
        Pessoa pessoa = buscaPessoaPorId(codigo);
        pessoa.setAtivo(flag);
        persistePessoa(pessoa);
    }

    private Pessoa buscaPessoaPorId(Long id) {
        return pessoaRepositorio.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Pessoa com id " + id + " não encontrada."));
    }

    private Pessoa persistePessoa(Pessoa pessoa) {
        return pessoaRepositorio.save(pessoa);
    }
}
