package com.devsuperior.dsmeta.services;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.repositories.SaleRepository;

// a annotation @Service serve para registar a classe SaleService como um componente do sistema
@Service
public class SaleService {
	
	/* para retornar os dados da função  findSales() é necessário chamar a Repository para acessar ao banco
	 * @Autowired é uma annotation que realiza a importanção automática, injetando uma instância da Repository*/
	@Autowired
	private SaleRepository repository;
	
	/*Page é o tipo de dado que é retornado pela função findSales()
	 * o retorno da função será encontrar todas as vendas*/
	public  Page<Sale> findSales(String minDate, String maxDate, Pageable pageable) {
		
		//cria data no dia de hoje usando o pradrão do sistema
		LocalDate today = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());
		
		/*LocalDate.parse(parametro que vem do front) - converte as datas de texto para o LocalDate do Java
		 * expressão condicional ternária: se a data mix estiver vázia coloque a data de um ano atrás (verdadeiro), se não coloque a data informada (falso)*/
		LocalDate min = minDate.equals("") ? today.minusDays(365) : LocalDate.parse(minDate);
		//expressão condicional ternária: se a data max estiver vázia coloque a data de hoje (verdadeiro), se não coloque a data informada (falso)
		LocalDate max = maxDate.equals("") ? today : LocalDate.parse(maxDate);
		
		
		return repository.findSales(min, max, pageable);
		
	}

}
