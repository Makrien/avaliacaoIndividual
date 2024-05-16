package br.org.serratec.avaliacaoIndividual.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.org.serratec.avaliacaoIndividual.dto.MinMaxPrecoDTO;
import br.org.serratec.avaliacaoIndividual.dto.PedidoDTO;
import br.org.serratec.avaliacaoIndividual.service.PedidoService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {
	
	@Autowired
	private PedidoService service;
	
	@GetMapping
	public ResponseEntity<List<PedidoDTO>> listarTodos() {
		return ResponseEntity.ok(service.buscarTodos());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<PedidoDTO>> listarPorId(@PathVariable Long id) {
		return ResponseEntity.ok(service.buscarPorId(id));
	}	

	@Valid
	@PostMapping
	public ResponseEntity<PedidoDTO> cadastrarPedido(@RequestBody PedidoDTO pedidoCadastrado) {
		service.cadastrar(pedidoCadastrado);
		return new ResponseEntity<PedidoDTO>(pedidoCadastrado, HttpStatus.CREATED);
	}
	
	@Valid
	@PutMapping("/{id}")
	public ResponseEntity<Optional<PedidoDTO>> atualizarPedido(@PathVariable Long id, @RequestBody PedidoDTO pedidoAtualizado) {
		return ResponseEntity.ok(service.atualizar(id, pedidoAtualizado));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> excluirPedido(@PathVariable Long id) {
		if (service.excluir(id)) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
	}
	
	@GetMapping("/cliente")
	public ResponseEntity<List<PedidoDTO>> listarPorCliente(@RequestBody String cliente) {
		return ResponseEntity.ok(service.buscarPorCliente(cliente));
	}
	
	@GetMapping("/prato")
	public ResponseEntity<List<PedidoDTO>> listarPorPrato(@RequestBody String prato) {
		return ResponseEntity.ok(service.buscarPorPrato(prato));
	}
	
	@GetMapping("/preco-min")
	public ResponseEntity<List<PedidoDTO>> listarPorPrecoMin(@RequestBody Double precoMin) {
		return ResponseEntity.ok(service.buscarPorPrecoMin(precoMin));
	}
	
	public ResponseEntity<List<PedidoDTO>> listarPorIntervaloPreco(@RequestBody MinMaxPrecoDTO minMaxPreco) {
		return ResponseEntity.ok(service.buscarPorIntervaloPreco(minMaxPreco.min(), minMaxPreco.max()));
	}
	
}
