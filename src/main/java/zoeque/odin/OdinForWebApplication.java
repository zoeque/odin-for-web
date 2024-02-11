package zoeque.odin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"zoeque.odin"})
@EnableJpaRepositories(basePackages = "zoeque.odin")
@ComponentScan(basePackages = {"zoeque.odin"})
public class OdinForWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(OdinForWebApplication.class, args);
	}

}
