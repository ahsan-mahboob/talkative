package ae.gov.dubaicustoms.tkteurekadiscovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class TktEurekaDiscoveryApplication {

	public static void main(String[] args) {
		SpringApplication.run(TktEurekaDiscoveryApplication.class, args);
	}

}
