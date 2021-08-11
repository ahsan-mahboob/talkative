package ae.gov.dubaicustoms.tktindex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import ae.gov.dubaicustoms.tktindex.model.MessageObj;

@SpringBootApplication
@EnableEurekaClient
public class TktIndexApplication implements RepositoryRestConfigurer {

	public static void main(String[] args) {
		try {
            SpringApplication app = new SpringApplication(TktIndexApplication.class);
            app.run(args);
        } catch(Throwable ex) {
            ex.printStackTrace();
        }
	}

	@Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
        config.exposeIdsFor(MessageObj.class);
    }
}
