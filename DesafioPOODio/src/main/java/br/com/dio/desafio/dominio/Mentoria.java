package br.com.dio.desafio.dominio;

import java.time.LocalDate;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class Mentoria extends Conteudo {

	private LocalDate data;

	@Override
	public double calcularXp() {
		return XP_PADRAO * 10d;
	}

	@Override
	public String toString() {
		return "Mentoria [data=" + data + ", título=" + getTitulo() + ", descrição=" + getDescricao() + "]";
	}

}
