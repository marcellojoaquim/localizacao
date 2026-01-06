package com.mjdsilva.localizacao;

import com.mjdsilva.localizacao.domain.entity.Cidade;
import com.mjdsilva.localizacao.service.CidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class LocalizacaoApplication implements CommandLineRunner {

	@Autowired
	private CidadeService cidadeService;

	@Override
	public void run(String... args) throws Exception {
		var cidade = new Cidade(null, "fortaleza", null);
		//cidadeService.salvarCidade();
		//cidadeService.listarCidades();
		//listarCidadesPorNome();
		//listarCidadesPorHabitantes();
		//listarCidadeEntreValoresHabitantes();
		//listarCidadesComecadasPor();
		//listarCidadesTerminadasPor();
		//listarCidadesQueContem();
		//cidadeService.listarCidadesLike();
		//listarCidadesLikeIgnoreCase();
		//listarCidadesComMenosDe();
		//listarCidadesComMaisDe();
		//listarCidadesComMaisDeENomeIgualA();
		//cidadeService.listarCidadesComMaisDeOuNomeIgualA();
		//cidadeService.listaPaginada();
		//cidadeService.filtroDinamico(cidade).forEach(System.out::println);
		//cidadeService.listarCidadesBySpecs();
		//cidadeService.listarCidadesBySpecsOuHabitantes();
		cidadeService.listarCidadesBySpecsAndHabitantes();
	}

	public static void main(String[] args) {
		SpringApplication.run(LocalizacaoApplication.class, args);
	}

}
