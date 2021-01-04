package ru.naumow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import ru.naumow.mongo.driver.MarketDriverRepositoryImpl;
import ru.naumow.mongo.repo.MarketSpringRepository;
import ru.naumow.mongo.template.MarketTemplateRepository;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext context
                = SpringApplication.run(Application.class, args);

        MarketSpringRepository springRepository
                = context.getBean(MarketSpringRepository.class);

        MarketDriverRepositoryImpl driverRepository
                = context.getBean(MarketDriverRepositoryImpl.class);

        MarketTemplateRepository templateRepository
                = context.getBean(MarketTemplateRepository.class);

        /*ProductRepository productRepository
                = context.getBean(ProductRepository.class);

        Product product1 = Product.builder().name("name1").build();
        productRepository.save(product1);
        Product product2 = Product.builder().name("name2").build();
        productRepository.save(product2);
        Product product3 = Product.builder().name("name3").build();
        productRepository.save(product3);*/
        /*Market market = springRepository.findById("5fe91b0fcfbcff09a0f192cb").orElseThrow(IllegalArgumentException::new);
        market.setRating(30);
        market.setStatus("CLOSE");
        market.setProducts(Arrays.asList(product1, product2, product3));
        springRepository.save(market);*/

        System.out.println("------");
        System.out.println(springRepository.find(20, "OPEN", 3));
        System.out.println("------");
        System.out.println(driverRepository.find(20, "OPEN", 3));
        System.out.println("------");
        System.out.println(templateRepository.find(20, "OPEN", 3));
        System.out.println("------");

    }

}
