package com.mjdsilva.localizacao;

import com.mjdsilva.localizacao.domain.entity.Cidade;
import com.mjdsilva.localizacao.domain.repository.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.transaction.Transactional;


@SpringBootApplication
public class LocalizacaoApplication implements CommandLineRunner {

	@Autowired
	private CidadeRepository cidadeRepository;

	@Override
	public void run(String... args) throws Exception {
		//salvarCidade();
		//listarCidades();
		//listarCidadesPorNome();
		//listarCidadesPorHabitantes();
		//listarCidadeEntreValoresHabitantes();
		//listarCidadesComecadasPor();
		//listarCidadesTerminadasPor();
		//listarCidadesQueContem();
	}

	@Transactional
	void salvarCidade() {
		var cidade = new Cidade(1L,"Sao Paulo", 12396372L);
		cidadeRepository.save(cidade);
	}
	void listarCidadesPorNome() {
		cidadeRepository.findByNome("Recife").forEach(System.out::println);
	}
	void listarCidades() {
		cidadeRepository.findAll().forEach(System.out::println);
	}

	void listarCidadesPorHabitantes() {
		cidadeRepository.findByHabitantes(670400L).forEach(System.out::println);
	}

	void listarCidadesComecadasPor() {
		cidadeRepository.findByNomeStartingWith("Sao").forEach(System.out::println);
	}

	void listarCidadesTerminadasPor() {
		cidadeRepository.findByNomeEndingWith("o").forEach(System.out::println);
	}

	void listarCidadesQueContem() {
		cidadeRepository.findByNomeContaining("ao").forEach(System.out::println);
	}

	void listarCidadeEntreValoresHabitantes() {
		cidadeRepository.findCidadesInHabitantesRange(670400L, 1000000L).forEach(System.out::println);
	}

	public static void main(String[] args) {
		SpringApplication.run(LocalizacaoApplication.class, args);
	}

}
