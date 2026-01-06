package com.mjdsilva.localizacao.domain.repository.specs;

import com.mjdsilva.localizacao.domain.entity.Cidade;
import org.springframework.data.jpa.domain.Specification;

public abstract class CidadeSpecs {

    public static Specification<Cidade> nomeEqual(String nome) {
        return (root, query, criteriaBuilder)
                -> criteriaBuilder.equal(root.get("nome"), nome);
    }

    public static Specification<Cidade> idEqual(Long id) {
        return (root, query, criteriaBuilder)
                -> criteriaBuilder.equal(root.get("id"), id);
    }

    public static Specification<Cidade> habitantesMaiorOuIgual(Long num) {
        return (root, query, criteriaBuilder)
                -> criteriaBuilder.greaterThanOrEqualTo(root.get("habitantes"), num);
    }

    public static Specification<Cidade> habitantesBetween(Long min, Long max) {
        return (root, query, criteriaBuilder)
                -> criteriaBuilder.between(root.get("habitantes"), min, max);
    }

    public static Specification<Cidade> nomeLike(String nome) {
        return (root, query, criteriaBuilder)
                -> criteriaBuilder.like(criteriaBuilder.upper(root.get("nome")), "%"+nome+"%".toUpperCase());
    }

}
