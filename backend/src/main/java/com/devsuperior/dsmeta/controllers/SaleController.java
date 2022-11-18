package com.devsuperior.dsmeta.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.services.SaleService;

/*a annotation @RestController indica que é um controlador e a @RequestMapping é responsável por informar a rota no frontend*/
@RestController
@RequestMapping(value ="/sales")
public class SaleController {
	
	@Autowired
	private SaleService service;
	
	/*método que disponibilizará a página de vendas para o frontend
	 * annotation @GetMapping é responsável por configurar a resposta via web usandp HTTP
	 * o argumento Pageable traz os dados páginados
	 * passamos as datas como string porque o dados trafegam via web como texto e depois são convertidos para data
	 * a annotation @RequestParam indica o nome que terá o parâmentro na web, caso o minDate não seja informado no front então o texto será considerado vazio*/
	@GetMapping
	public Page<Sale> findSales(
			@RequestParam(value="minDate", defaultValue="") String minDate, 
			@RequestParam(value="maxDate", defaultValue="") String maxDate, 
			Pageable pageable){
		return service.findSales(minDate, maxDate, pageable);
		
	}
}
