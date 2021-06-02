package ru.gb.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import ru.gb.demo.configuration.ApplicationConfiguration;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Component
public class Main {
    private final ProductRepository productRepository;
    private final CartFactory cartFactory;

    public Main(ProductRepository productRepository, CartFactory cartFactory) {
        this.productRepository = productRepository;
        this.cartFactory = cartFactory;
    }

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
    }

    @PostConstruct
    public void command() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            Cart cart = null;
            while (true) {
                String read = reader.readLine();
                System.out.println(read);
                if (read.startsWith(Command.CREATE_CART)) {
                    cart = cartFactory.getCart();
                }
                if (read.startsWith(Command.ADD_ALL)) {
                    cart.addAll(productRepository.getList());
                }
                if (read.startsWith(Command.ADD_BI_ID)) {
                    cart.addAll(productRepository.getList());
                }
                System.out.println("Cart: " + cart);
                System.out.println("include: ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
