package com.devsuperior.dsmeta.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.repositories.SaleRepository;

// com a annotation @Service serve para registar a classe SaleService como um componente do sistema
@Service
public class SaleService {
	
	/* para retornar os dados da função  findSales() é necessário chamar a Repository para acessar ao banco
	 * @Autowired é uma annotation que realiza a importanção automática, injetando uma instância da Repository*/
	@Autowired
	private SaleRepository repository;
	
	/*List é o tipo de dado que é retornado pela função findSales()
	 * o retorno da função será encontrar todas as vendas*/
	public List<Sale> findSales() {
		return repository.findAll();
	}

}
