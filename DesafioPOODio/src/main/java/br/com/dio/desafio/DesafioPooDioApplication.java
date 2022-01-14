package br.com.dio.desafio;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.dio.desafio.dominio.Bootcamp;
import br.com.dio.desafio.dominio.Curso;
import br.com.dio.desafio.dominio.Dev;
import br.com.dio.desafio.dominio.Mentoria;

@SpringBootApplication
public class DesafioPooDioApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DesafioPooDioApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		init();
	}

	private static void init() {
		Bootcamp bootcamp = Bootcamp.builder()
				// nome
				.nome("Bootcamp Java Developer")
				// descrição
				.descricao("Descrição Bootcamp Java Developer").build();

		bootcamp.getConteudos().add(criarCurso());
		bootcamp.getConteudos().add(criarMentoria());

		Dev israel = Dev.builder().nome("Israel").build();

		Dev camila = Dev.builder().nome("Camila").build();

		// israel
		realizarTrilha(israel, bootcamp, 1);

		// camila
		realizarTrilha(camila, bootcamp, 2);
	}

	private static void realizarTrilha(Dev dev, Bootcamp bootcamp, int step) {
		imprimirDev(dev);
		dev.inscreverBootcamp(bootcamp);
		imprimirDev(dev);
		for (int i = 0; i < step; i++) {
			dev.progredir();
		}
		imprimirDev(dev);
	}

	private static void imprimirDev(Dev dev) {
		System.out.println(String.format("Dev: %s", dev.getNome()));
		System.out.println(String.format("Conteúdos Inscritos: %s", dev.getConteudosInscritos().toString()));
		System.out.println(String.format("Conteúdos Concluidos: %s", dev.getConteudosConcluidos().toString()));
		System.out.println(String.format("XP: %.2f", dev.calcularTotalXp()));
	}

	private static Curso criarCurso() {
		return Curso.builder().titulo("Curso JS").descricao("Descrição Curso JS").cargaHoraria(4).build();
	}

	private static Mentoria criarMentoria() {
		return Mentoria.builder().titulo("Mentoria Java").descricao("Descrição da Mentoria Java").data(LocalDate.now())
				.build();
	}

}
