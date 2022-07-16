package co.myLibrary.front;

import co.myLibrary.front.repository.BookProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FrontApplication implements CommandLineRunner{
    @Autowired
    private CustomProperties customProperties;
    @Autowired
    private BookProxy bookProxy;

	public static void main(String[] args) {
		SpringApplication.run(FrontApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {
        System.out.println("apiURL : " + customProperties.getApiUrl());
        System.out.println("Testing bookproxy : " + bookProxy.getBooks());
    }

}
