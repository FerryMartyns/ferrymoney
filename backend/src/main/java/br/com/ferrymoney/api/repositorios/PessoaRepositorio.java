package br.com.ferrymoney.api.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ferrymoney.api.entidades.Pessoa;

public interface PessoaRepositorio extends JpaRepository<Pessoa, Long>{
}
