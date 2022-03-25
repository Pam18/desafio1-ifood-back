package br.com.foodtrack.tracking.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.foodtrack.tracking.Dao.PedidoDao;
import br.com.foodtrack.tracking.model.Pedido;

@RestController
@CrossOrigin("*")
public class PedidoController {
	
	@Autowired
	private PedidoDao dao;
	
	@GetMapping("/pedidos")
	public ResponseEntity<?> listarTodos(){
		List<Pedido> pedidos = (List<Pedido>) dao.findAll();		
		return ResponseEntity.status(200).body(pedidos);
	}
	
	@GetMapping("/pedidos/abertos")
	public ResponseEntity<?> listarAbertos(){
		List<Pedido> pedidos = (List<Pedido>) dao.buscarPedidosPorStatus("aberto");		
		return ResponseEntity.status(200).body(pedidos);
	}

}