package br.com.dio.desafio.dominio;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Bootcamp {

	private String nome;
	private String descricao;
	private final LocalDate dataInicial = LocalDate.now();
	private final LocalDate dataFim = dataInicial.plusDays(45);

	private final Set<Dev> devsInscritos = new HashSet<>();
	private final Set<Conteudo> conteudos = new LinkedHashSet<>();
}
