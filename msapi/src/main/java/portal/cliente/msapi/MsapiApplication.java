package portal.cliente.msapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"portal.cliente.msapi.*"})
public class MsapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsapiApplication.class, args);
	}

}
