package ae.gov.dubaicustoms.tktgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class TktGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(TktGatewayApplication.class, args);
	}


}
