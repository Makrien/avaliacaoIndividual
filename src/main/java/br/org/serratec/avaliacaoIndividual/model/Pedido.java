package br.org.serratec.avaliacaoIndividual.model;

import br.org.serratec.avaliacaoIndividual.dto.PedidoDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "pedidos")
public class Pedido {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_pedido")
	private Long id;
	private String cliente;
	private String prato;
	private Double preco;
	
	public Pedido() {}
	
	public Pedido(Long id, String cliente, String prato, Double preco) {
		super();
		this.id = id;
		this.cliente = cliente;
		this.prato = prato;
		this.preco = preco;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCliente() {
		return cliente;
	}
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	public String getPrato() {
		return prato;
	}
	public void setPrato(String prato) {
		this.prato = prato;
	}
	public Double getPreco() {
		return preco;
	}
	public void setPreco(Double preco) {
		this.preco = preco;
	}
	
	public PedidoDTO toDto() {
		return new PedidoDTO(this.id, this.cliente, this.prato, this.preco);
	}
}
