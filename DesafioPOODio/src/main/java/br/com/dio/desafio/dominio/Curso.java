package br.com.dio.desafio.dominio;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Curso {

	private String titulo;
	private String descricao;
	private int cargaHoraria;
}
