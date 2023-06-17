package br.com.ferrymoney.api.servicos;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.ferrymoney.api.entidades.Categoria;
import br.com.ferrymoney.api.repositorios.CategoriaRepositorio;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoriaServico {

    private final CategoriaRepositorio categoriaRepositorio;

    @Transactional(readOnly = true)
    public List<Categoria> buscaTodas() {
        return categoriaRepositorio.findAll();
    }

    @Transactional
    public Categoria inserir(Categoria categoria) {
        return categoriaRepositorio.save(categoria);
    }
}
