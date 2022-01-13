package br.com.dio.desafio.dominio;

import java.time.LocalDate;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Mentoria {

	private String titulo;
	private String descricao;
	private LocalDate data;
}
