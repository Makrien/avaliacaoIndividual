package br.org.serratec.avaliacaoIndividual.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.org.serratec.avaliacaoIndividual.dto.PedidoDTO;
import br.org.serratec.avaliacaoIndividual.model.Pedido;
import br.org.serratec.avaliacaoIndividual.repository.PedidoRepository;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository repo;

	public List<PedidoDTO> buscarTodos() {
		return repo.findAll()
				.stream()
				.map(c -> new PedidoDTO(c.getId(), c.getCliente(), c.getPrato(), c.getPreco()))
				.toList();
	}

	public Optional<PedidoDTO> buscarPorId(Long id) {
		Optional<Pedido> pedidoEntity = repo.findById(id);

		if (pedidoEntity.isPresent()) {
			return Optional.of(pedidoEntity.get().toDto());
		}
		return Optional.empty();
	}

	public List<PedidoDTO> buscarPorCliente(String cliente) {
		return repo.findByClienteContainingIgnoreCase(cliente)
				.stream()
				.map(p -> new PedidoDTO(p.getId(), p.getCliente(), p.getPrato(), p.getPreco()))
				.collect(Collectors.toList());
	}

	public List<PedidoDTO> buscarPorPrato(String prato) {
		return repo.findByPratoContainingIgnoreCase(prato)
				.stream()
				.map(p -> new PedidoDTO(p.getId(), p.getCliente(), p.getPrato(), p.getPreco()))
				.collect(Collectors.toList());
	}

	public List<PedidoDTO> buscarPorPrecoMin(Double precoMin) {
		return repo.findByPrecoGreaterThan(precoMin)
				.stream()
				.map(p -> new PedidoDTO(p.getId(), p.getCliente(), p.getPrato(), p.getPreco()))
				.collect(Collectors.toList());
	}

	public List<PedidoDTO> buscarPorIntervaloPreco(Double min, Double max) {
		return repo.findByPrecoBetween(min, max)
				.stream()
				.map(p -> new PedidoDTO(p.getId(), p.getCliente(), p.getPrato(), p.getPreco()))
				.collect(Collectors.toList());
	}

	public PedidoDTO cadastrar(PedidoDTO pedido) {
		Pedido pedidoEntity = repo.save(pedido.toEntity());
		return pedidoEntity.toDto();
	}

	public Optional<PedidoDTO> atualizar(Long id, PedidoDTO pedidoAtualizado) {
		if (repo.existsById(id)) {
			Pedido pedidoEntity = pedidoAtualizado.toEntity();
			pedidoEntity.setId(id);
			repo.save(pedidoEntity);
			return Optional.of(pedidoEntity.toDto());			
		}
		return Optional.empty();
	}

	public boolean excluir(Long id) {
		if (repo.existsById(id)) {
			repo.deleteById(id);
			return true;
		}
		return false;
	}

}
