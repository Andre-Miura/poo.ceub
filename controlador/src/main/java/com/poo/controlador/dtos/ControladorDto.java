package com.poo.controlador.dtos;

	import jakarta.validation.constraints.NotBlank;
	import jakarta.validation.constraints.NotNull;

	public record ControladorDto( @NotBlank String nome, 
							@NotBlank String cpf, 
							@NotNull Double capacidade) {
}
