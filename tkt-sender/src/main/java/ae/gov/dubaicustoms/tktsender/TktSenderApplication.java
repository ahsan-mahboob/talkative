package ae.gov.dubaicustoms.tktsender;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import io.micrometer.core.aop.TimedAspect;
import io.micrometer.core.instrument.MeterRegistry;


@SpringBootApplication
@EnableEurekaClient
public class TktSenderApplication {

	public static void main(String[] args) {
		try {
            SpringApplication app = new SpringApplication(TktSenderApplication.class);
            app.run(args);
        } catch(Throwable ex) {
            ex.printStackTrace();
        }
	}
	
	@Bean
	public TimedAspect timedAspect(MeterRegistry registry) {
	    return new TimedAspect(registry);
	}

}
