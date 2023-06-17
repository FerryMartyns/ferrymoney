package br.com.ferrymoney.api.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ferrymoney.api.entidades.Categoria;

public interface CategoriaRepositorio extends JpaRepository<Categoria, Long>{
}
