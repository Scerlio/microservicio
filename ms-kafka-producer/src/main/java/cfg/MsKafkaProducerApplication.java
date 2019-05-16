package cfg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@EnableDiscoveryClient
@SpringBootApplication
@ComponentScan(basePackages = "modelo")
public class MsKafkaProducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsKafkaProducerApplication.class, args);
	}

}
