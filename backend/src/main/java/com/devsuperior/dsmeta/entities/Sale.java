package com.devsuperior.dsmeta.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/*annotation(palavra reservada) para pré-processamento na hora de compilar o projeto e gerar o programa executável.
 * a classe será equivalente a uma tabela do banco de dados relacional e o nome da tabela pode ser customizado com a 
annotation @Table()
*/
@Entity
@Table(name = "tb_sales")
public class Sale {
	
	/*variáveis
	 *a annotation @Id torna o dado da variável id único.
	 *a annotation @GenerateValue é responsável por deixar os dados no caso da variável id autoencrementável 
	*/ 	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private LocalDate date;
	private String sellerName;
	private Integer visited;
	private Integer deals;
	private Double amount;
	
	//construtor/função
	public Sale() {
		
	}

	//métodos de acesso
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getSellerName() {
		return sellerName;
	}

	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}

	public Integer getVisited() {
		return visited;
	}

	public void setVisited(Integer visited) {
		this.visited = visited;
	}

	public Integer getDeals() {
		return deals;
	}

	public void setDeals(Integer deals) {
		this.deals = deals;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}
	
	
}
