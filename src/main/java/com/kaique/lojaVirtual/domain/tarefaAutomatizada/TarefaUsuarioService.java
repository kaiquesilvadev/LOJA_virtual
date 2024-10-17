package com.kaique.lojaVirtual.domain.tarefaAutomatizada;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import com.kaique.lojaVirtual.domain.dto.EmailDTO;
import com.kaique.lojaVirtual.domain.entity.Usuario;
import com.kaique.lojaVirtual.domain.repositories.UsuarioRepository;
import com.kaique.lojaVirtual.domain.services.EmailService;

@Service
public class TarefaUsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private EmailService emailService;

	@Autowired
	private TemplateEngine templateEngine;

	//@Scheduled(initialDelay = 12000, fixedDelay = 80000) /* Roda a cada 2 minutos */
	@Scheduled(cron = "0 0 11 * * *", zone = "America/Sao_Paulo") /*Vai rodar todo dia as 11 horas da manhã horario de Sao paulo*/
	public void notificarUserTrocaSenha() throws InterruptedException {
		LocalDate cutoffDate = LocalDate.now().minusDays(89);

		List<Usuario> list = usuarioRepository.usuarioSenhaVencida(cutoffDate);

		for (Usuario usuario : list) {

			EmailDTO dto = new EmailDTO();

			dto.setTo(usuario.getLogin());
			dto.setSubject("Aviso de Expiração de Senha");

			// Cria o contexto do Thymeleaf
			Context context = new Context();
			context.setVariable("username", usuario.getPessoa().getNome());
			
			// Gera o conteúdo HTML a partir do template
            String htmlContent = templateEngine.process("password-expiration-notification", context);
			dto.setBody(htmlContent);

			emailService.sendEmail(dto);

			//Thread.sleep(3000);
		}

	}

}