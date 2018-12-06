package nr.co.ahmedeid.pos.launch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration 
@EnableAutoConfiguration 
@EnableJpaRepositories("nr.co.ahmedeid.pos.repository")
@ComponentScan(basePackages = { "nr.co.ahmedeid.pos" })
@EntityScan("nr.co.ahmedeid.pos.model") 
public class PosRestServices 
{
	
	
	 public static void main(String[] args) 
	 {
	        SpringApplication.run(PosRestServices.class, args);
	 }
	 
	 
}
