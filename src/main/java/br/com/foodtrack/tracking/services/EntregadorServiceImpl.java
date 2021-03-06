
package br.com.foodtrack.tracking.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.foodtrack.tracking.DTO.EntregadorDTO;
import br.com.foodtrack.tracking.Dao.EntregadorDao;
import br.com.foodtrack.tracking.model.Entregador;

@Component
public class EntregadorServiceImpl implements IEntregadorService {

	@Autowired
	private EntregadorDao dao;

	@Override
	public List<Entregador> buscaTodos() {
		return dao.buscarTodos();
	}

	@Override
	public EntregadorDTO buscarUm(Integer id) throws Exception {
		
		
			Entregador resposta = dao.findById(id).orElse(null);
			if(resposta != null) {
				
				return  EntregadorDTO.fromEntregador(resposta);
			}
		
			 	throw new Exception("404 - NOT FOUND");
	
		
		}
		
		
	

}
