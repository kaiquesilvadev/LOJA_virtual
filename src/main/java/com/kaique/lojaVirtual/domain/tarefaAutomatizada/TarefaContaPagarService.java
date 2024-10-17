package com.kaique.lojaVirtual.domain.tarefaAutomatizada;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import com.kaique.lojaVirtual.domain.dto.EmailDTO;
import com.kaique.lojaVirtual.domain.entity.ContaPagar;
import com.kaique.lojaVirtual.domain.repositories.ContaPagarRepository;
import com.kaique.lojaVirtual.domain.services.EmailService;

@Service
public class TarefaContaPagarService {
	
	@Autowired
	private ContaPagarRepository repository;

	@Autowired
	private EmailService emailService;

	@Autowired
	private TemplateEngine templateEngine;
	
	/*TODO : vai rodar todo dia as 10 da noite pra avisar que a conta esta proxima a vencer*/
	@Scheduled(cron = "0 0 22 * * *", zone = "America/Sao_Paulo")
	public void avisoContasProcimaAVencer() {
	    LocalDate dataAtual = LocalDate.now();

	    LocalDate umDiaAFrente = dataAtual.plusDays(1);
	    LocalDate doisDiasAFrente = dataAtual.plusDays(2);

	    Date dataUmDiaAFrente = Date.valueOf(umDiaAFrente);
	    Date dataDoisDiasAFrente = Date.valueOf(doisDiasAFrente);

	    List<ContaPagar> contasProximasVencimento = repository.findContasProximasVencimento(dataUmDiaAFrente, dataDoisDiasAFrente);
	    
	    for (ContaPagar contaPagar : contasProximasVencimento) {
	        if (contaPagar.getEmpresa() != null && contaPagar.getEmpresa().getEmail() != null) {

	            EmailDTO dto = new EmailDTO();
	            dto.setTo(contaPagar.getEmpresa().getEmail());
	            dto.setSubject("Aviso de Conta a Vencer");

	            Context context = new Context();
	            context.setVariable("username", contaPagar.getEmpresa().getNome());
	            context.setVariable("contaDescricao", contaPagar.getDescricao());
	            context.setVariable("valorTotal", contaPagar.getValortotal());
	            context.setVariable("dataVencimento", contaPagar.getDtVencimento());

	            String htmlContent = templateEngine.process("conta-proxima-vencimento", context);
	            dto.setBody(htmlContent);

	            emailService.sendEmail(dto);

	            try {
	                Thread.sleep(3000);
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }
	        }
	    }
	}
}
