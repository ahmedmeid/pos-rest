package nr.co.ahmedeid.pos.launch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration 
@EnableAutoConfiguration 
@ComponentScan("nr.co.ahmedeid.pos")
@EnableJpaRepositories("nr.co.ahmedeid.pos.repository")
public class PosRestServices 
{
	
	
	 public static void main(String[] args) 
	 {
	        SpringApplication.run(PosRestServices.class, args);
	 }
	 
	 
}
