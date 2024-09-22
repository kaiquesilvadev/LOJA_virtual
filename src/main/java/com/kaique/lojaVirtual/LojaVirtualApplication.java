package com.kaique.lojaVirtual;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;
@EnableFeignClients
@EnableScheduling// Habilita o agendamento de tarefas com @Scheduled 
@SpringBootApplication
@ComponentScan(basePackages = {"com.*"})
//@EnableJpaRepositories(basePackages = {"com.kaique.lojaVirtual.domain.repository"})
@EnableTransactionManagement
public class LojaVirtualApplication {

	public static void main(String[] args) {
		SpringApplication.run(LojaVirtualApplication.class, args);
	}

}
	