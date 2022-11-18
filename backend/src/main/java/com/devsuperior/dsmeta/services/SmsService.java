package com.devsuperior.dsmeta.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.repositories.SaleRepository;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@Service
public class SmsService {

	@Value("${twilio.sid}")
	private String twilioSid;

	@Value("${twilio.key}")
	private String twilioKey;

	@Value("${twilio.phone.from}")
	private String twilioPhoneFrom;

	@Value("${twilio.phone.to}")
	private String twilioPhoneTo;
	
	/*é necessário chamar a Repository para acessar a venda no banco de dados*/
	@Autowired
	private SaleRepository saleRepository;

	/*método de teste para envio de mensagem pego na documentação da Twilio*/
	public void sendSms(Long saleId) {
		/*fará a busca da venda por id*/
		Sale sale = saleRepository.findById(saleId).get();
		
		/*retorna o número do mês e o ano*/
		String date = sale.getDate().getMonthValue() + "/" + sale.getDate().getYear();
		
		/*mensagem com os dados da venda, passando nome do vendedor, mês/ano e valor da venda*/
		String msg = "O Vendedor " + sale.getSellerName() + "foi destaque em " + date
				+ " com um total de R$ " + String.format("%.2f", sale.getAmount()) ;

		Twilio.init(twilioSid, twilioKey);

		PhoneNumber to = new PhoneNumber(twilioPhoneTo);
		PhoneNumber from = new PhoneNumber(twilioPhoneFrom);

		Message message = Message.creator(to, from, msg).create();

		System.out.println(message.getSid());
	}
}
