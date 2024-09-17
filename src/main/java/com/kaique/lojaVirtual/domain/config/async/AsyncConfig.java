package com.kaique.lojaVirtual.domain.config.async;

import java.util.concurrent.Executor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * Esta classe configura a execução de métodos assíncronos na aplicação
 * Spring Boot. Ao habilitar o suporte a processamento assíncrono, 
 * essa configuração permite que tarefas possam ser executadas em segundo plano
 * sem bloquear o fluxo principal.
 */

@Configuration
/* Habilita a execução assíncrona na aplicação, permitindo que métodos anotados com @Async sejam executados em threads separadas.*/
@EnableAsync
public class AsyncConfig  implements AsyncConfigurer{

	@Override
    @Bean
    public Executor getAsyncExecutor() {
    	
        // Criação e configuração do pool de threads para execução assíncrona
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        
        // Define o número mínimo de threads no pool
        executor.setCorePoolSize(10);
        
        // Define o número máximo de threads no pool
        executor.setMaxPoolSize(20);
        
        // Capacidade máxima de tarefas que podem ser enfileiradas
        executor.setQueueCapacity(500);
        
        // Define um prefixo para o nome das threads criadas
        executor.setThreadNamePrefix("Assyncrono Thread-");
        
        // Inicializa o executor após configurar suas propriedades
        executor.initialize();
        return executor;
    }
}