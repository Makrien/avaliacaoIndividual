package br.org.serratec.avaliacaoIndividual.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.org.serratec.avaliacaoIndividual.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
	List<Pedido> findByClienteContainingIgnoreCase(String cliente);
	List<Pedido> findByPratoContainingIgnoreCase(String prato);
	List<Pedido> findByPrecoGreaterThan(Double preco);
	List<Pedido> findByPrecoBetween(Double min, Double max);
}
