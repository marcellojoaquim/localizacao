package com.mjdsilva.localizacao.service;

import com.mjdsilva.localizacao.domain.entity.Cidade;
import com.mjdsilva.localizacao.domain.repository.CidadeRepository;
import com.mjdsilva.localizacao.domain.repository.specs.CidadeSpecs;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CidadeService {

    private final CidadeRepository cidadeRepository;

    public CidadeService(CidadeRepository cidadeRepository) {
        this.cidadeRepository = cidadeRepository;
    }

    @Transactional
    public void salvarCidade() {
        var cidade = new Cidade(1L,"Sao Paulo", 12396372L);
        cidadeRepository.save(cidade);
    }
    public void listarCidadesPorNome() {
        cidadeRepository.findByNome("Recife").forEach(System.out::println);
    }
    public void listarCidades() {
        cidadeRepository.findAll().forEach(System.out::println);
    }

    public void listarCidadesPorHabitantes() {
        cidadeRepository.findByHabitantes(670400L).forEach(System.out::println);
    }

    public void listarCidadesComecadasPor() {
        cidadeRepository.findByNomeStartingWith("Sao").forEach(System.out::println);
    }

    public void listarCidadesTerminadasPor() {
        cidadeRepository.findByNomeEndingWith("o").forEach(System.out::println);
    }

    public void listarCidadesQueContem() {
        cidadeRepository.findByNomeContaining("ao").forEach(System.out::println);
    }

    public void listarCidadesLike() { cidadeRepository.findByNomeLike("%a", Sort.by("habitantes")).forEach(System.out::println); }

    public void listarCidadesLikeIgnoreCaseJPQL() { cidadeRepository.findByNomeLikeIgnoreCaseJPQL("For%").forEach(System.out::println); }

    public void listarCidadesLikeIgnoreCase() {
        cidadeRepository.findByNomeLikeIgnoreCase("For%").forEach(System.out::println);
    }

    public void listarCidadeEntreValoresHabitantes() {
        cidadeRepository.findCidadesInHabitantesRange(670400L, 1000000L).forEach(System.out::println);
    }

    public void listarCidadesComMenosDe() {
        cidadeRepository.findByHabitantesLessThan(1000000L).forEach(System.out::println);
    }

    public void listarCidadesComMaisDe() {
        cidadeRepository.findByHabitantesGreaterThan(1000000L).forEach(System.out::println);
    }

    public void listarCidadesComMaisDeENomeIgualA(){
        cidadeRepository.findByHabitantesGreaterThanEqualAndNomeLikeIgnoreCase(1000000L, "%a%").forEach(System.out::println);
    }

    public void listarCidadesComMaisDeOuNomeIgualA(){
        cidadeRepository.findByHabitantesGreaterThanEqualOrNomeLikeIgnoreCase(1000000L, "%a").forEach(System.out::println);
    }

    public void listaPaginada() {
        Pageable pageable = PageRequest.of(1, 4);
        cidadeRepository.findByNomeLikeIgnoreCaseJPQLPaginado("%a", pageable).forEach(System.out::println);
    }

    public List<Cidade> filtroDinamico(Cidade cidade) {
        ExampleMatcher matcher = ExampleMatcher.matching().withIgnoreCase();
        Example<Cidade> example = Example.of(cidade, matcher);
        return cidadeRepository.findAll(example);
    }

    //Specifications

    public Specification<Cidade> buscarPorId(Long id) {
        Specification<Cidade> spec = CidadeSpecs.idEqual(id);
        return spec;
    }

    public void listarCidadesBySpecs() {
        Specification<Cidade> spec = CidadeSpecs.nomeEqual("Fortaleza");
        cidadeRepository.findAll(spec).forEach(System.out::println);
    }

    public void listarCidadesBySpecsOuHabitantes() {
        Specification<Cidade> spec = CidadeSpecs.nomeEqual("Sao Paulo").or(CidadeSpecs.habitantesMaiorOuIgual(10000L));
        cidadeRepository.findAll(spec).forEach(System.out::println);
    }

    public void listarCidadesBySpecsAndHabitantes() {
        Specification<Cidade> spec = CidadeSpecs.nomeEqual("Sao Paulo").and(CidadeSpecs.habitantesMaiorOuIgual(10000L));
        cidadeRepository.findAll(spec).forEach(System.out::println);
    }

    public void habitantesBetween() {
        Specification<Cidade> spec = CidadeSpecs.habitantesBetween(10000L, 700000L);
        cidadeRepository.findAll(spec).forEach(System.out::println);
    }

    public void buscarPorNomeSpec() {
        Specification<Cidade> spec = CidadeSpecs.nomeLike("Sao Paulo");
        cidadeRepository.findAll(spec).forEach(System.out::println);
    }

    public void filtroDinamicoSpec( Cidade filtro) {
        Specification<Cidade> specs = Specification.where(
                (root, query, criteriaBuilder) -> criteriaBuilder.conjunction());

        if(filtro.getId() != null) {
            specs = specs.and(CidadeSpecs.idEqual(filtro.getId()));
        }

        if(StringUtils.hasText(filtro.getNome())) {
            specs = specs.and(CidadeSpecs.nomeLike(filtro.getNome()));
        }

        if(filtro.getHabitantes() != null){
            specs = specs.and(CidadeSpecs.habitantesMaiorOuIgual(filtro.getHabitantes()));
        }

        cidadeRepository.findAll(specs).forEach(System.out::println);
    }
}
