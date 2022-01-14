package br.com.dio.desafio;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.dio.desafio.dominio.Bootcamp;
import br.com.dio.desafio.dominio.Curso;
import br.com.dio.desafio.dominio.Dev;
import br.com.dio.desafio.dominio.Mentoria;

@SpringBootTest
class DesafioPooDioApplicationTests {

	@Test
	void adicionaCurso() {
		Bootcamp b = criarBootcamp();
		Curso c = criarCurso();
		b.getConteudos().add(c);
		assertThat(b.getConteudos().size() == 1);
	}

	@Test
	void adicionaMentoria() {
		Bootcamp b = criarBootcamp();
		Mentoria m = criarMentoria();
		b.getConteudos().add(m);
		assertThat(b.getConteudos().size() == 1);
	}

	@Test
	void progredir() {
		Bootcamp b = criarBootcamp();

		Mentoria m = criarMentoria();
		b.getConteudos().add(m);

		Curso c = criarCurso();
		b.getConteudos().add(c);

		int totalConteudo = b.getConteudos().size();
		int step = 1;

		Dev israel = Dev.builder().nome("Israel").build();

		realizarTrilha(israel, b, step);

		assertThat(israel.getConteudosInscritos().size() == totalConteudo - 1);
		assertThat(israel.getConteudosConcluidos().size() == step);
	}

	@Test
	void increverBootcamp() {
		Bootcamp b = criarBootcamp();

		Mentoria m = criarMentoria();
		b.getConteudos().add(m);

		Curso c = criarCurso();
		b.getConteudos().add(c);

		Dev israel = Dev.builder().nome("Israel").build();
		israel.inscreverBootcamp(b);

		assertThat(b.getDevsInscritos().size() == 1);
	}

	private static Bootcamp criarBootcamp() {
		return Bootcamp.builder()
				// nome
				.nome("Bootcamp Java Developer")
				// descrição
				.descricao("Descrição Bootcamp Java Developer").build();
	}

	private static void realizarTrilha(Dev dev, Bootcamp bootcamp, int step) {
		dev.inscreverBootcamp(bootcamp);
		for (int i = 0; i < step; i++) {
			dev.progredir();
		}
	}

	private static Curso criarCurso() {
		return Curso.builder().titulo("Curso JS").descricao("Descrição Curso JS").cargaHoraria(4).build();
	}

	private static Mentoria criarMentoria() {
		return Mentoria.builder().titulo("Mentoria Java").descricao("Descrição da Mentoria Java").data(LocalDate.now())
				.build();
	}

}
