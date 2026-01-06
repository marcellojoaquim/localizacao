package com.mjdsilva.localizacao.domain.repository.specs;

import com.mjdsilva.localizacao.domain.entity.Cidade;
import org.springframework.data.jpa.domain.Specification;

public abstract class CidadeSpecs {

    public static Specification<Cidade> nomeEqual(String nome) {
        return (root, query, criteriaBuilder)
                -> criteriaBuilder.equal(root.get("nome"), nome);
    }

    public static Specification<Cidade> habitantesMaiorOuIgual(Long num) {
        return (root, query, criteriaBuilder)
                -> criteriaBuilder.greaterThanOrEqualTo(root.get("habitantes"), num);
    }
}
