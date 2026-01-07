package com.mjdsilva.localizacao.domain.repository;

import com.mjdsilva.localizacao.domain.entity.Cidade;
import com.mjdsilva.localizacao.domain.repository.projections.CidadeProjections;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CidadeRepository extends JpaRepository<Cidade, Long>, JpaSpecificationExecutor<Cidade> {

    List<Cidade> findByNome(String nome);
    List<Cidade> findByHabitantes(Long habitantes);
    List<Cidade> findByNomeStartingWith(String nome);
    List<Cidade> findByNomeEndingWith(String nome);
    List<Cidade> findByNomeContaining(String nome);
    List<Cidade> findByNomeLike(String nome, Sort sort);
    List<Cidade> findByNomeLikeIgnoreCase(String nome);

    @Query("SELECT c FROM Cidade c WHERE UPPER(c.nome) LIKE UPPER(?1)")
    List<Cidade> findByNomeLikeIgnoreCaseJPQL(String nome);

    @Query("SELECT c FROM Cidade c WHERE UPPER(c.nome) LIKE UPPER(?1)")
    Page<Cidade> findByNomeLikeIgnoreCaseJPQLPaginado(String nome, Pageable page);

    @Query("SELECT c FROM Cidade c WHERE c.habitantes BETWEEN :minValue AND :maxValue")
    List<Cidade> findCidadesInHabitantesRange(@Param("minValue") Long minValue, @Param("maxValue") Long maxValue);

    List<Cidade> findByHabitantesLessThan(Long habitantes);
    List<Cidade> findByHabitantesGreaterThan(Long habitantes);

    List<Cidade> findByHabitantesGreaterThanEqualAndNomeLikeIgnoreCase(Long habitantes, String nome);
    List<Cidade> findByHabitantesGreaterThanEqualOrNomeLikeIgnoreCase(Long habitantes, String nome);

    //SQL nativo
    @Query(nativeQuery = true, value = "SELECT id_cidade as id, nome, qtd_habitantes FROM tb_cidade as c WHERE c.nome =:nome")
    List<CidadeProjections> findByNomeSQLNativo(@Param("nome") String nome);

}
