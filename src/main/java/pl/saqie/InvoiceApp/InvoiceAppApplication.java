package pl.saqie.InvoiceApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class InvoiceAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(InvoiceAppApplication.class, args);
	}

}
