package com.devsuperior.dsmeta.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.services.SaleService;

/*a annotation @RestController indica que é um controlador e a @RequestMapping é responsável por informar a rota no frontend*/
@RestController
@RequestMapping(value ="/sales")
public class SaleController {
	
	@Autowired
	private SaleService service;
	
	/*método que disponibilizará a lista de vendas para o frontend
	 * annotation @GetMapping é responsável por configurar a resposta via web usandp HTTP*/
	@GetMapping
	public List<Sale> findSales(){
		return service.findSales();
		
	}
}
