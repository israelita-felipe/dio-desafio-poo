package br.com.dio.desafio.dominio;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class Curso extends Conteudo {

	private int cargaHoraria;

	@Override
	public double calcularXp() {
		return XP_PADRAO * cargaHoraria;
	}

	@Override
	public String toString() {
		return "Curso [cargaHoraria=" + cargaHoraria + ", título=" + getTitulo() + ", descrição=" + getDescricao()
				+ "]";
	}

}
