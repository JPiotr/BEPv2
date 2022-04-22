package wsei.project.BEP;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import wsei.project.BEP.entityes.Type;
import wsei.project.BEP.mongo.TypeRepository;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class BepApplication {
	public static void main(String[] args) {
		SpringApplication.run(BepApplication.class, args);
	}

	//Initializer
	@Bean
	CommandLineRunner runner(TypeRepository repository){
		return args -> {
			//reset types repo
			repository.deleteAll();
			repository.insert(new Type("RDP"));
			repository.insert(new Type("VPN"));
			repository.insert(new Type("Enova"));
			repository.insert(new Type("TeamViewer"));
			repository.insert(new Type("Anydesk"));
			repository.insert(new Type("Inny"));
			repository.insert(new Type("DB"));
		};
	}


}

