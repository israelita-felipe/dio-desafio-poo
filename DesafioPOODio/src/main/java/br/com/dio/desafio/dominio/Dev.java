package br.com.dio.desafio.dominio;

import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Dev {

	private String nome;
	private final Set<Conteudo> conteudosInscritos = new LinkedHashSet<>();
	private final Set<Conteudo> conteudosConcluidos = new LinkedHashSet<>();

	public void inscreverBootcamp(Bootcamp bootcamp) {
		this.conteudosInscritos.addAll(bootcamp.getConteudos());
		bootcamp.getDevsInscritos().add(this);
	}

	public void progredir() {
		Optional<Conteudo> conteudo = this.conteudosInscritos.stream().findFirst();
		if (conteudo.isPresent()) {
			this.conteudosConcluidos.add(conteudo.get());
			this.conteudosInscritos.remove(conteudo.get());
		} else {
			System.err.println("Você não está matriculado em nenhum conteúdo");
		}
	}

	public double calcularTotalXp() {
		return this.conteudosConcluidos.stream().mapToDouble(Conteudo::calcularXp).sum();
	}
}
