package br.org.serratec.avaliacaoIndividual.dto;

import br.org.serratec.avaliacaoIndividual.model.Pedido;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record PedidoDTO(
		Long id,
		@NotBlank(message = "Campo não pode ser vazio, insira um nome para o cliente.")
		String cliente,
		@NotBlank(message = "Campo não pode ser vazio, insira um prato.")
		String prato,
		@NotNull
		Double preco) {
	
	public Pedido toEntity() {
		return new Pedido(this.id, this.cliente, this.prato, this.preco);
	}
}
