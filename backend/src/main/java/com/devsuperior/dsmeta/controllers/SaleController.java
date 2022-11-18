package com.devsuperior.dsmeta.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.services.SaleService;
import com.devsuperior.dsmeta.services.SmsService;

/*a annotation @RestController indica que é um controlador e a @RequestMapping é responsável por informar a rota no frontend*/
@RestController
@RequestMapping(value ="/sales")
public class SaleController {
	
	@Autowired
	private SaleService service;
	
	@Autowired
	private SmsService smsService;
	
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
	 /*void significa vázio, não será retornado um dado, essa função faz apenas a chamada do método sendSms da classe SmsService
	  * a annotation @ PathVariable indica que um parâmetro de método deve ser vinculado a uma variável de modelo de URI. Compatível com métodos manipuladores anotados RequestMapping*/
	@GetMapping("/{id}/notification")
	public void notifySms(@PathVariable Long id) {
		smsService.sendSms(id);
	}
	
}
