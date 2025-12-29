package com.mjdsilva.localizacao;

import com.mjdsilva.localizacao.domain.entity.Cidade;
import com.mjdsilva.localizacao.domain.repository.CidadeRepository;
import com.mjdsilva.localizacao.service.CidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.transaction.Transactional;


@SpringBootApplication
public class LocalizacaoApplication implements CommandLineRunner {

	@Autowired
	private CidadeService cidadeService;

	@Override
	public void run(String... args) throws Exception {
		//cidadeService.salvarCidade();
		cidadeService.listarCidades();
		//listarCidadesPorNome();
		//listarCidadesPorHabitantes();
		//listarCidadeEntreValoresHabitantes();
		//listarCidadesComecadasPor();
		//listarCidadesTerminadasPor();
		//listarCidadesQueContem();
		//listarCidadesLike();
		//listarCidadesLikeIgnoreCase();
		//listarCidadesComMenosDe();
		//listarCidadesComMaisDe();
		//listarCidadesComMaisDeENomeIgualA();
		//listarCidadesComMaisDeOuNomeIgualA();
	}

	public static void main(String[] args) {
		SpringApplication.run(LocalizacaoApplication.class, args);
	}

}
