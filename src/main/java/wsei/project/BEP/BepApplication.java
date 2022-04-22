package wsei.project.BEP;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import wsei.project.BEP.entityes.Type;
import wsei.project.BEP.mongo.TypeRepository;

//todo:Front End
//todo:Angular front api


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
			repository.insert(new Type("RDP","data/rdp.svg"));
			repository.insert(new Type("VPN", "data/vpn.svg"));
			repository.insert(new Type("Enova", "data/enova.svg"));
			repository.insert(new Type("TeamViewer", "data/tv.svg"));
			repository.insert(new Type("Anydesk", "data/ad.svg"));
			repository.insert(new Type("Inny", "data/other.svg"));
			repository.insert(new Type("DB", "data/db.svg"));
		};
	}


}

