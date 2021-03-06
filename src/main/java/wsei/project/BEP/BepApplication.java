package wsei.project.BEP;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import wsei.project.BEP.entityes.*;
import wsei.project.BEP.entityes.Access.Access;
import wsei.project.BEP.entityes.Access.DB;
import wsei.project.BEP.entityes.Access.Enova;
import wsei.project.BEP.mongo.Access.AccesRepository;
import wsei.project.BEP.mongo.Access.DBRepository;
import wsei.project.BEP.mongo.Access.EnovaRepository;
import wsei.project.BEP.mongo.ClientRepository;
import wsei.project.BEP.mongo.TypeRepository;

import java.util.Arrays;

//todo:Front End
//todo:Angular front api
//todo:Refactor Access
//todo:Refactor public and private elements and methods


@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class BepApplication {
	public static void main(String[] args) {
		SpringApplication.run(BepApplication.class, args);
	}

	//Initializer
	@Bean
	CommandLineRunner runner(TypeRepository trepo, ClientRepository crepo, AccesRepository arepo, DBRepository dbrepo, EnovaRepository erepo){
		return args -> {
			//reset types repo
			trepo.deleteAll();
			trepo.insert(new Type("RDP","data/rdp.svg"));
			trepo.insert(new Type("VPN", "data/vpn.svg"));
			trepo.insert(new Type("Enova", "data/enova.svg"));
			trepo.insert(new Type("TeamViewer", "data/tv.svg"));
			trepo.insert(new Type("Anydesk", "data/ad.svg"));
			trepo.insert(new Type("DB", "data/db.svg"));
			trepo.insert(new Type("Inny", "data/other.svg"));

//			if(arepo.count() != 0){
//				arepo.deleteAll();
//				Access initial = new Access();
//				List<Access> alist = new ArrayList<Access>();
//				alist.add(initial);
//				arepo.insert(initial);
//				crepo.deleteAll();
//				Client initial_client = new Client("!00000","!Inicjacyjny",0);
//				initial_client.setAccesList(alist);
//				crepo.insert(initial_client);
//			}
			crepo.deleteAll();
			arepo.deleteAll();
			dbrepo.deleteAll();
			erepo.deleteAll();

			DB db = new DB("!Inicjacyjny","0.0.0.0","sa","****",true);
			dbrepo.insert(db);
			Enova e = new Enova("!Inicjacyjny","****",
					db,
			trepo.findByName("Enova"));
			erepo.insert(e);
			Client c = new Client("!00000","!Inicjacyjny",0);
			Access a = new Access();


			a.getEnovaAccesses().add(e);
			a.getEnovaAccesses().add(e);
			arepo.insert(a);
			c.setAcces(a);
			crepo.insert(c);
		};
	}


	@Bean
	public CorsFilter corsFilter(){
		UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
		CorsConfiguration corsConfiguration = new CorsConfiguration();
		corsConfiguration.setAllowCredentials(true);
		corsConfiguration.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
		corsConfiguration.setAllowedHeaders(Arrays.asList("Origin", "Access-Control-Allow-Origin", "Content-Type",
				"Accept", "Jwt-Token", "Authorization", "Origin, Accept", "X-Request-With", "Access-Control-Request-Method",
				"Access-Control-Request-Headers"));
		corsConfiguration.setExposedHeaders(Arrays.asList("Origin", "Content-Type", "Accept", "Jwt-Token", "Authorization",
				"Access-Control-Allow-Origin", "Access-Control-Allow-Origin", "Access-Control-Allow-Credential", "Filename"));
		corsConfiguration.setAllowedMethods(Arrays.asList("GET","POST","PUT","DELETE","OPTIONS"));
		urlBasedCorsConfigurationSource.registerCorsConfiguration("/**",corsConfiguration);
		return new CorsFilter(urlBasedCorsConfigurationSource);
	}


}

