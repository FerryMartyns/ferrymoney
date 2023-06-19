package br.com.ferrymoney.api.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ferrymoney.api.entidades.Lancamento;

public interface LancamentoRepositorio extends JpaRepository<Lancamento, Long>{
}
